/**
 * Set Timout and set Interval
 */

//set Timeout(function, delay, [param1], [param2]) 
// setTimeout(()=> console.log("Bonjour"), 3000);
// setTimeout((name)=> console.log("Bonjour" + name), 5000, "Roger");

//setInterval (function, delay, [param])
// let instervalID = setInterval(()=> console.log("Hello"), 5000);

//Stopper l'interval au bout de 10s
// setTimeout(function(){
//     clearInterval(instervalID)
// }, 10000);

//Compte à rebours à partir d'un parametre, qui se lance au bout de 3s
// Corrige
const NB = 10;

function compteArebours(nb){
    let nombre = nb;

    console.log(nombre);
    let intervalId = setInterval(function(){
        nombre--;
        console.log(nombre);
        if(nombre == 0){clearInterval(intervalId)};
    }, 100)
}

setTimeout(compteArebours, 3000, 10);





