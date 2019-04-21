export default class CarParkView {
    constructor (){
        
    }

    generateHTML() {
        return `
        <div class="item item-${this.id}">
            <ul>
                <li>Name: ${this.name}</li>
                <li>No of Spaces: ${this.spaces}</li>
                <li>Free Spaces: ${this.free}</li>
                <li>Status: ${this.status}</li>
                <li>Movement: ${this.movement}</li>
            </ul>
        </div>
        `;
    }
}