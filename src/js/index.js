import CarPark from './model/CarPark'
import carParkView from './view/CarParkView'
import './../style/app.css'

const state = {};

const getResults = async() => {
    state.carPark = new CarPark();
    await state.carPark.getCarParkData();

    carParkView.renderResults(state.carPark.carParks.results)
};

getResults();
