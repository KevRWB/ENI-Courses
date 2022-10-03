/*
Cours fonctions anonymes et lambda
*/

//declaration d'une fonction anonyme calculant l'age d'une personne en fonction de son annee de naissance
const calculerAge = function (anneDeNaissance){
    let date = new Date();
    return date.getFullYear() - anneDeNaissance;
}

console.log(calculerAge(1986));

//Utilisation en mode AUTO - INVOCATION

age = (function(anneDeNaissance){
    let date = new Date();
    return date.getFullYear() - anneDeNaissance;
})(1923);

console.log(age);

//FONCTION LAMBDA

const calculerAutreAge = (anneDeNaissance) => {
    let date = new Date();
    return date.getFullYear() - anneDeNaissance;
}

let autreAge = calculerAutreAge(1356);
console.log(autreAge);

//FONCTION LAMBDA AUTO APPELANTE
(() => {
    let date = new Date();
    console.log(date.toLocaleDateString());
})();
