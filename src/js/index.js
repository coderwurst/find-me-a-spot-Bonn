
const herokuCORS = 'https://cors-anywhere.herokuapp.com/';
const parkingSpacesURL = 'http://www.bcp-bonn.de/stellplatz/bcpext.xml';

var request = new XMLHttpRequest();
request.open("GET", `${herokuCORS}${parkingSpacesURL}`);
request.onreadystatechange = function() {
    if (request.readyState == 4 && request.status == 200) {
        console.log(request.responseXML);
    }
};

request.send();
