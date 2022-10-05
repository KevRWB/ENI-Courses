
let button = document.getElementById('validation');
let input = document.getElementById('input');
let inputValue = document.getElementById('input').value;


button.addEventListener('mouseover', function(){  
    inputValue = document.getElementById('input').value;
    if(inputValue == ""){
        changePosition(button);
    }
})

//on change input
function entryInput(){
    button.className = "aGauche";
}

//fonction changement position
function changePosition(element){
    if(element.className == "aDroite"){
        element.className = "aGauche";
    }else{
        element.className = "aDroite";
    }
}

//fonction si clique bouton
button.addEventListener('click', function(){
    alert("Bravo ! Votre saisie est : " + document.getElementById('input').value);
})
