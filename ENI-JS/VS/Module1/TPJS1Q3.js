/*
TP JS 1 QUestion 3 
*/

let sentence = "une phrase quelquonque";

let aSentence = sentence.split(" ");

for (i = 0; i < aSentence.length; i++) {
    word =  aSentence[i];
    let char =  word.charAt(0).toUpperCase();
    wordChanged = word.replace(word.charAt(0), char);
    aSentence[i] = wordChanged;
}

let sentenceToUpperCase = aSentence.join(" ");

console.log(sentenceToUpperCase);


