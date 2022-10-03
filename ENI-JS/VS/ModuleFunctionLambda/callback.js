/**
 * Cours CallBack - JS
 * */

//init tableau de valeurs
const VALUES = [1,2,3,4,5];

//fonction necessicant callback en parametre
function editValues(aNumber, callback){
    let newValues = [];
    for (let index = 0; index < aNumber.length; index++) {
        newValues.push(callback(aNumber[index]));
    }

    return newValues;
}

//Utilisation avec fonction Lambda
let newValues = editValues(VALUES, (number) => number*5);
console.log(newValues);

//Utilisation avec foncton anonyme
newValues = editValues(VALUES, function(number){
    return number - 12;
});
console.log(newValues);

///////////////////////////////////////////////////////
//Parametre par default

function helloGyuOrWoman(name = "Mr or Ms"){ // valeur par default
    console.log("Hello " + name);
}

helloGyuOrWoman("Keke");
helloGyuOrWoman();

///////////////////////////////////////////////////////
// Avec la methode map()

//with lambda
newValues = VALUES.map((number) => number * 3);
console.log(newValues);

//with anonym
newValues = VALUES.map(function(number){ return number *12});
console.log(newValues);

// fait l'action de join pour chaque element du tableau
newValues = VALUES.map(function(){ return VALUES.join("-")});
console.log(newValues);

