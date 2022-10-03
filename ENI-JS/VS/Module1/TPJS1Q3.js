/*
TP JS 1 QUestion 3 
*/

//init variables
let sentence = "une phrase quelquonque";

//split la phrase en String vers un array
let aSentence = sentence.split(" ");

//pour chaque element du tableau (mot dans la phrase) ...
for (i = 0; i < aSentence.length; i++) {
    word =  aSentence[i]; //stockage du mot en cours dans une variable
    let char =  word.charAt(0).toUpperCase(); //stockage du 1er caractere du mot
    wordChanged = word.replace(word.charAt(0), char); // passage du premier caractere du mot en majuscule et stockage du nouveau mot dans une variable
    aSentence[i] = wordChanged; // le mot en cours dans l'Array est remplacé par le nouveau mot modifié
}

//recreer un String du tableau
let sentenceToUpperCase = aSentence.join(" ");

// affichage resultat
console.log(sentenceToUpperCase);


