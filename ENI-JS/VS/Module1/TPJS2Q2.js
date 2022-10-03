/*
TP - Question 2

*/

let sentenceToSort= "phrase a trier par ordre alphabetique";

let sentenceToArray = sentenceToSort.split("");

sentenceToArray.sort();

let sentenceSorted = sentenceToArray.join();

console.log(sentenceSorted);

