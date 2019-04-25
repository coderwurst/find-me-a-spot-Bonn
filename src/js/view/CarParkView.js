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
            <li>Status: ${carPark.status}</li>
            <li>Movement: ${carPark.movement}</li>
        </ul>
    </div>
    `;

    elements.carParkList.insertAdjacentHTML('beforeend', html);
}
