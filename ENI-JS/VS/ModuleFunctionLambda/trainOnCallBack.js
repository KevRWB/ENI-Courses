/**
 * Train on CallBack 
 */

//Function itaratint in a String Array and call a callback method on each word
function doSthgToAString (aList, callback){
  let tempArray = [];
   
  for (let index = 0; index < aList.length; index++) {
    tempArray.push(callback(aList[index]));
  }
  return tempArray;
}

//init String list
strList = ['Coucou', 'hello', 'Bonjour', 'Guten Tag'];

//Function toUpperCase
let newList = doSthgToAString(strList, (word) => word.toUpperCase());
//Function concat with length of the word
let otherList = doSthgToAString(strList, (word) => word.concat(" ", word.length));

//Print result
// console.log(strList);
// console.log(newList);
// console.log(otherList);

//With map method
thirdList = strList.map((word) => word.replace("o", "A"));
fourthList = strList.map(function(){return strList.join("-")});
fifthList = strList.map(function(word){return word.toUpperCase()});
console.log(strList);
console.log(thirdList);
console.log(fifthList);


