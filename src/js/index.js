import CarPark from './model/CarPark'
import { renderElements } from './view/CarParkView'
import './../style/app.css'

import converter from 'xml-js'

const state = {};
const herokuCORS = 'https://cors-anywhere.herokuapp.com/';
const parkingSpacesURL = 'http://www.bcp-bonn.de/stellplatz/bcpext.xml';


const getCarParkData = async () => {
    let request = new XMLHttpRequest();
    state.carParks = [];

    request.open("GET", `${herokuCORS}${parkingSpacesURL}`);
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            const jsObject = converter.xml2js(request.responseText, {compact: true});
            const carParks = Array.from(jsObject.parkhaeuser.parkhaus);
            carParks.forEach((currentElement, i) => {
               
                const newCarPark = new CarPark(currentElement.lfdnr._text, currentElement.bezeichnung._text, currentElement.gesamt._text, currentElement.frei._text, currentElement.status._text, currentElement.tendenz._text);
                
                state.carParks.push(newCarPark);
            });

            renderElements(state.carParks);
        }
    };
   await request.send();
}

getCarParkData();
