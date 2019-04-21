import CarPark from './model/CarPark'
import * as carParkView from './view/CarParkView'
import './../style/app.css'

const state = {};

const getResults = async() => {
    state.carPark = new CarPark();
    await state.carPark.getCarParkData();

    /*carParkView.generateHTML(state.carPark.results);*/
};

getResults();
