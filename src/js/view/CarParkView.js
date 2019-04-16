export default class CarParkView {
    constructor (){
        
    }

    generateHTML() {
        return `<div class="carpark clearfix"><div class="carpark__name">${this.name}</div><div class="clearfix"><div class="carpark__spaces">${this.spaces}</div><div class="carpark__free">${this.free}</div><div class="carpark__status">${this.status}</div><div class="carpark__movement">${this.movement}</div></div></div>`;
    }
}