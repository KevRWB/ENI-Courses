/**
 * Event DEMO - Eni JS
 * 
 */

//Fonction validation de l'input
function validateTheInput() {
    console.log("Validation ok");
    let valueInput = document.getElementById('theInput').value;
    if (valueInput) { console.log("Vous venez de saisir : " + valueInput); }

    /////
    document.getElementById("theSecondButton").addEventListener('click', function () {
        console.log("J'ai cliqué sur le deuxieme bouton")
    })

}

// Fonction addlink vers site de l'ENI
function addlink() {

    let link = document.createElement('a');
    link.innerText = 'ENI';
    link.setAttribute('href', 'https://www.eni-ecole.fr/');
    link.setAttribute('target', '_blank');
    link.id = "theAlink";
    //test si l'element existe
    if (!document.getElementById('theAlink')) {
        document.getElementById('theLinkButton').insertAdjacentElement('afterend', link);
    }
}

///////////////////////////////////////
/// Fonction color buttons
function colorButtons() {
    let inputs = document.querySelectorAll('input[type=button]'); 
    setInterval(stroboscope, 1000, inputs);  

   
}

function stroboscope(inputs){
    for (const button of inputs) {
        if(button.className == 'colorButton'){
            button.className = 'colorButtonBis';
        }else{
            button.className = 'colorButton';
        }
    }
}

