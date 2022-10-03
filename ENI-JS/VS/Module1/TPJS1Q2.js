/*
TP - Question 2
*/

let sentenceToSort= "phrase a trier par ordre alphabetique";
// je coupe la chaine de caractere a chaque caractere
let sentenceToArray = sentenceToSort.split("");
// trie du array par ordre alphabetique     
sentenceToArray.sort();
//joint les caracteres du tableau en un String
let sentenceSorted = sentenceToArray.join("");
//retire les espaces aux extremites
sentenceSorted = sentenceSorted.trim();

console.log(sentenceSorted);

