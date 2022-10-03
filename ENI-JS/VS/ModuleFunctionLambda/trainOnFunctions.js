/**
 * Page to train with anonymous functions and lambda
 * 
 */
//Fonction lambda auto-appelante INIT
let dateStartSession;
let timeStartSession;

(()=> {
    let date = new Date;
    dateStartSession = date.toLocaleDateString();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    timeStartSession = `${hours}h${minutes}mn${seconds}s` ;
})();

console.log(`Date de début de session : ${dateStartSession}. Heure de début de session : ${timeStartSession}`);


//Lambda methods
const printSomething = (txt) => {console.log(txt);}

const add = (nb1 = 0, nb2 = 0) => nb1 + nb2;
const substract = (nb1, nb2) => {return nb1 - nb2}; // methode du dessus preferable - plus de {}
const printAWord = () => {console.log("Coucou");}

printAWord();

//Anonymous methods
const anonymousFunction = function(){return "I'm anonymous"};
console.log(anonymousFunction());

//Anonymous function auto-appelante
dateInitValue = (function(){
    return new Date;
})();
console.log(dateInitValue);

