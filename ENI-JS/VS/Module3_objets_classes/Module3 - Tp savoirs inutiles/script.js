/**
 * Script TP savoir inutiles
 * 
 */
///// Onload



//////////// Classe

class Savoir {
    constructor( txt, auteur, date, id = 0){
        this.txt = txt;
        this.auteur = auteur;
        this.date = date;
    }
}

/////////////////////////////
//list des savoir init
let listSavoir = [];
let id = 0;


//listener sur bouton valider
document.getElementById("valider").addEventListener("click", function(){

    let txt = document.getElementById("inputSavoir").value;
    let auteur = document.getElementById("auteur").value;
    let date = document.getElementById("date").valueAsDate;

    if(txt && auteur && date){
        let tempSavoir = new Savoir(txt, auteur, date);
        id++;
        this.id = id;
        listSavoir.push(tempSavoir);
    
        //clear fields
        document.getElementById("inputSavoir").value = "";
        document.getElementById("auteur").value = "";
        document.getElementById("date").valueAsDate = new Date();
    
        //print results
        affichageSavoirs(listSavoir); 
    }else {
        alert("Veuillez saisir tous les champs")
    }
})

//Fonction affichage
function affichageSavoirs(list){

    let divTest = document.getElementById("divContainer");
    if(divTest){
        console.log('coucou');
        divTest.remove();
    }
    //////////////////
    let divContainer = document.createElement('div');
    divContainer.setAttribute("id", "divContainer");

    for (const savoir of list) {
        let title = document.createElement('h2');
        let div = document.createElement('div');
        let txt = document.createElement('p');
        let auteur = document.createElement('p');
        let date = document.createElement('p');

        title.innerText = "Savoir"
        txt.innerText = savoir.txt;
        auteur.innerText = "Auteur : " + savoir.auteur;
        date.innerText = "Date : " + savoir.date.toLocaleDateString();
        
        div.appendChild(title);
        div.appendChild(txt);
        div.appendChild(auteur);
        div.appendChild(date);
        div.setAttribute("onclick", "supp(this)");
        div.setAttribute("id", savoir.id);
        div.className = "divSavoir";

        divContainer.appendChild(div);
    }
    document.body.appendChild(divContainer);
}

///////////////////  delete savoir
function supp(elem){
    let confirmation = confirm("Voulez-vous vraiment supprimer ce savoir ?");

    if(confirmation){
        let index = elem.id;
        console.log(index);
        listSavoir.splice(index-1, 1);
        console.log(listSavoir);
        elem.remove();
        affichageSavoirs(listSavoir);
    }
}

///// Sorted methods
//Sort by auteur
let btnSortAuteur = document.getElementById("sortAuteur");
btnSortAuteur.addEventListener("click", function(){
    listSavoir.sort((a, b) => (a.auteur > b.auteur) ? 1 : -1);
    affichageSavoirs(listSavoir);
})

//Sort by date
let btnSortDate = document.getElementById("sortDate");
btnSortDate.addEventListener("click", function(){
    listSavoir.sort((a, b) => (a.date > b.date) ? 1 : -1);
    affichageSavoirs(listSavoir);
})

