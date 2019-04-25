import CarPark from './model/CarPark'
import { renderElements } from './view/CarParkView'
import './../style/app.css'

import converter from 'xml-js'

const state = {};
const herokuCORS = 'https://cors-anywhere.herokuapp.com/';
const parkingSpacesURL = 'http://www.bcp-bonn.de/stellplatz/bcpext.xml';


async function getCarParkData() {
    let request = new XMLHttpRequest();
    let result = [];
    request.open("GET", `${herokuCORS}${parkingSpacesURL}`);
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            const response = request.responseXML;
        
            const jsObject = converter.xml2js(request.responseText, {compact: true});
            const carParks = Array.from(jsObject.parkhaeuser.parkhaus);
            carParks.forEach((currentElement) => {
                var newCarPark = new CarPark(currentElement.lfdnr, currentElement.bezeichnung, currentElement.gesamt, currentElement.frei, currentElement.status, currentElement.tendenz);

                result.push(newCarPark);
            });

            /* TESTING ONLY
            const carparks = jsObject.parkhaeuser;
            const carparksString = JSON.stringify(carparks, null, 4); 
            console.log(`Car Park data: ${carparksString}`);*/

            this.carParks = result;
            console.log(this.carParks);
        }
    };
   request.send();
}

const getResults = async() => {
    await getCarParkData();
};

getResults();
