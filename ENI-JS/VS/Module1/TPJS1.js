/*
Question 1
*/ 
let nbTirages = 0;
let aNumbers = [];
let randNb;


while(aNumbers.length <99){
    randNb = Math.round(Math.random()*100);
    if(!aNumbers.includes(randNb)){
        aNumbers.push(randNb);
    }
    nbTirages ++;
}
console.log(aNumbers);
console.log(`Il a fallu ${nbTirages} pour compléter le tableau.`)