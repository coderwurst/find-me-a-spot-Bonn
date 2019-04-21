import converter from 'xml-js'

export default class CarPark {
    constructor() {
        this.herokuCORS = 'https://cors-anywhere.herokuapp.com/';
        this.parkingSpacesURL = 'http://www.bcp-bonn.de/stellplatz/bcpext.xml';
    }

    async getCarParkData() {
        let request = new XMLHttpRequest();
        let result = [];
        request.open("GET", `${this.herokuCORS}${this.parkingSpacesURL}`);
        request.onreadystatechange = function() {
            if (request.readyState == 4 && request.status == 200) {
                const response = request.responseXML;
                // console.log('response' + request.responseText);
                const body = Array.from(response.firstChild.children);
                body.forEach((currentElement) => {
                    result.push(currentElement);
                });
                
                // convert xml to json object
                const json = converter.xml2json(request.responseText, {compact: true});
                console.log("json: " + json);
                
                this.results = json;
            }
        };
       request.send();
       console.log('calling');
    }
}
