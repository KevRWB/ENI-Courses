/**
 * Script cours JS - DOM - ENI
 * 
 */
window.onload = function(){
    document.getElementById("title").innerText = "The Dom !";
}
///////////////////////////////////////////////////
/// add elements to DOM
function loadContent(){
    //change DOM title
    document.title ="The Dom page !";

    //Create element input and label
    let input = document.createElement('input');
    //change value of input and label
    input.value = "Valeur";
    input.setAttribute('value', 'Nouvelle valeur');
    input.id = "nom";
    input.className="form-input";

    //ajouter element au DOM
    let title =  document.getElementById('title');
    title.insertAdjacentElement('afterend' ,input);

    setTimeout(addDivLorem, 3000);
}

function addDivLorem(){
     //ajouter Div
     let div = document.createElement('div');
     div.innerText = "sdkfhmdqfkghmqdfklghqmdfkghqmdfkjghqmdfgsdfgsdfgsdfgsdfgdfkjghqmdfkjgh";
     document.querySelector('body').appendChild(div);
}

/////////////////////////////////////////////////
////Popups
function loadPopup(){
    let age = prompt('Quel age avez-vous ?');
if(age){
    alert("Vous avez " + age + " ans");

    let response =  confirm('Are you sure ?');

    if(!response){
        alert("T'es con ou quoi");
    }else {
        alert("Bravo tu connais ton âge !");
    }

    //affichage de l'age dans une balise h2, dans une div
    let divH2 = document.createElement('div');
    let h2 = document.createElement('h2');

    h2.innerText = age;

    divH2.appendChild(h2);
    document.body.appendChild(divH2);
}
}



//////////////////////////////////////////////

