/*
Structure.JS - Cour ENI

*/

const aVowel = ['a', 'e', 'i', 'o', 'u', 'y'];

console.log(aVowel.join("-"));

function isVowel(letter) {
    if(aVowel.includes(letter)){
        return true;
    }
    return false;
}

console.log(isVowel('a')); 

//script to count vowels in a sentence
let sentenceToTest = "Je vais ecrire une phrase";
let nbVowel = 0;

for (const letter of sentenceToTest) {
    if(isVowel(letter)){
        nbVowel ++;
    }
}

console.log("Il y a " + nbVowel + " voyelles dans la phrase : " + sentenceToTest);
console.log(`Il y a ${nbVowel} voyelles dans la phrase : ${sentenceToTest}`);

console.log(Number.MAX_VALUE * 2); //show infinity

let nbRand = Math.round(Math.random() * 100) ; //random entier entre 0 et 100
let nbRand2 = Number.parseInt(Math.random() * 100); // arrondi à l'entier inférieur
let nbRand3 = Number.parseInt("Bonjour");

console.log(`Nombre entier au hasard entre 1 et 100 : ${nbRand}. Nombre 2 : ${nbRand2}`);
console.log(nbRand3); // print NaN

//Date
let date = new Date();
console.log(date);
console.log(date.toLocaleDateString());
console.log(date.getFullYear());
console.log(date.getMonth()); // commence à zero.....