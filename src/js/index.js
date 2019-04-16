
import CarPark from './model/CarPark'

const herokuCORS = 'https://cors-anywhere.herokuapp.com/';
const parkingSpacesURL = 'http://www.bcp-bonn.de/stellplatz/bcpext.xml';

function getCarParkData() {
    let request = new XMLHttpRequest();
    let carParks = [];
    request.open("GET", `${herokuCORS}${parkingSpacesURL}`);
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            const response = request.responseXML;
            const body = Array.from(response.firstChild.children);
            body.forEach((currentElement) => {
                carParks.push(currentElement);
            });
            console.log(body);
        }
    };
    request.send();
}

getCarParkData();
