/**
 * Object Cours JS - ENI
 * 
 */

////////////////  Create object rocket
let rocket = {nbBooster: 12, nbFloor: 3, name: "Space-Dev"};
console.log(rocket);
//Print "name" attribute
console.log(rocket.name);
//Add attribute
rocket.pilot = "Laika";
console.log(rocket);

//add function with reference to attribute with "this"
rocket.launch = function(){
    console.log("La fusée s'envole avec " + this.pilot);
}
//use function launch
rocket.launch();

////////////////  Second rocket
let rocket2 = {nbBooster: 5, nbFloor: 8, name: "Space-Dev-2.0"};

//////////Create Array of rockets
let rockets = [rocket, rocket2, {nbBooster:19, nbFloor:256, name: "Space-Dev-3.0"}];
//Print rocket3 name
console.log(rockets[2].name);