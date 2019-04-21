import CarPark from './model/CarPark'
import * as carParkView from './view/CarParkView'
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

            const body = Array.from(response.firstChild.children);
            body.forEach((currentElement) => {
                result.push(currentElement);
            });
            
            const jsObject = converter.xml2js(request.responseText, {compact: true});
            const carparks = jsObject.parkhaeuser;
            const carparksString = JSON.stringify(carparks, null, 4); 
            console.log(`Car Park data: ${carparksString}`);

            this.results = carparks;
        }
    };
   request.send();
}

const getResults = async() => {
    state.carPark = new CarPark();
    await getCarParkData();

};

getResults();
