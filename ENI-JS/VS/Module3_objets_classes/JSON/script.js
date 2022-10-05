/*
Script Cours JSON - ENI
*/

fetch('data.json').then(response => response.json()).then(data => useData(data));

class Hobbit {
    constructor(name){
        this.name = name;
    }
}

class Elfe {
    constructor(name, age, arme){
        this.name = name;
        this.age = age;
        this.arme = arme;
    }
}

listHobbits = [];
listElfes = [];
let anneau;

function useData(data){

   let hobbits =  data.la_communaute_de_l_anneau.hobbits;
   for (const hobbit of hobbits) {
    let tempHobbit = new Hobbit(hobbit);
    listHobbits.push(tempHobbit);

   } 

   let elfes = data.la_communaute_de_l_anneau.elfes;
   for (const elfe of elfes) {
    let tempElfe = new Elfe(elfe.nom, elfe.age, elfe.arme);
    listElfes.push(tempElfe);
   }

   anneau = data.la_communaute_de_l_anneau.anneau;

   //print datas
   for (const hobbit of listHobbits) {
    console.log(hobbit);
   }
   for (const elfe of listElfes) {
    console.log(elfe);
   }
   console.log("anneau");

   //set in html
   let h2Hobbit = document.createElement("h2");
   h2Hobbit.innerText = "Hobbits";
   let ulHobbits = document.createElement("ul");
   for (const hobbit of listHobbits) {
    let li = document.createElement('li');
    li.innerText = hobbit.name;
    ulHobbits.appendChild(li);
   }

   let h2Elfes = document.createElement("h2");
   h2Elfes.innerText = "Elfes";
   let ulElfes = document.createElement("ul");
   for (const elfe of listElfes) {
    let li = document.createElement('li');
    li.innerText = "Nom : " + elfe.name + " - Age : " + elfe.age + " - Arme : " + elfe.arme;
    ulElfes.appendChild(li);
   }


   document.body.appendChild(h2Hobbit);
   document.body.appendChild(ulHobbits);
   document.body.appendChild(h2Elfes);
   document.body.appendChild(ulElfes);

}