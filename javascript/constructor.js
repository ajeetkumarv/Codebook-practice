const oldShuttle = function(targetPlanet) {
    this.targetPlanet = targetPlanet;
}

class SpaceShuttle {
    constructor(targetPlanet) {
        this.targetPlanet = targetPlanet;
    }
}

let dwarfPlanet = new oldShuttle('Pluto');
let zeus = new SpaceShuttle('Jupiter');

console.log(dwarfPlanet.targetPlanet);
console.log(zeus.targetPlanet);