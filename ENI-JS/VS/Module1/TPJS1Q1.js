/*
Question 1
*/ 

//Init variables
let nbTirages = 0;
let aNumbers = [];

//Tant que le tableau a eu taille inferieur a 100 ...
while(aNumbers.length < 100){
    let randNb = Math.floor(Math.random()*100); // tirage nb entier hasard entre 0 et 99 
    // si numero tiré n'est pas présent dans le tableau, on ajoute ce numero au tableau
    if(!aNumbers.includes(randNb)){
        aNumbers.push(randNb);
    }
    nbTirages ++; //incrément de nombre de tirages
}

//affichage des resultats
console.log(aNumbers);
console.log(`Il a fallu ${nbTirages} pour compléter le tableau.`);