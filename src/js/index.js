import CarPark from './model/CarPark'
import carParkView from './view/CarParkView'

const state = {};

const getResults = async() => {
    state.carPark = new CarPark();
    const results = await state.carPark.getCarParkData();

    console.log('results: ' + results);

};

getResults();
