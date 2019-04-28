import { elements } from '../constants'

export const renderElements = (carParks) => {
    console.log(`CarParkView - carparks: ${carParks}`);
    carParks.forEach((currentElement) => renderCarPark(currentElement));
}

const renderCarPark = (carPark) => {
    const html =  `
    <div class="item item-${carPark.id}">
        <ul>
            <li>Name: ${carPark.name}</li>
            <li>No of Spaces: ${carPark.spaces}</li>
            <li>Free Spaces: ${carPark.free}</li>
            <li>Status: ${carPark.status === 0 ? 'open' : 'closed'}</li>
            <li>Movement: ${carPark.movement === 1 ? 'steady' : (carPark.movement === 2 ? 'clearing out' : 'filling up')}</li>
        </ul>
    </div>
    `;

    elements.carParkList.insertAdjacentHTML('beforeend', html);
}
