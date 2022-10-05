function changeColor(event){   
   document.body.className = event.target.value;
}

function changeColor2(color){   
    document.body.className = color;
 }

 function changeColor3(){

    let select = document.getElementById('theSelect');

    //la fonction fléchée perd le contexte d'éxécution
    //this représente l'objet window
    select.addEventListener('change', (e) => {
        console.log(e)
        console.log(this)
        document.body.className = e.target.value
    })

    //la fonction anonyme garde le contexte d'éxécution
    // this représente l'élément HTML sur lequel je travaille
    select.addEventListener('change', function(e) {
        console.log(e)
        console.log(this)
        document.body.className = this.value
    })

 }

 //window.onload = changeColor3;

 //////////////////////////////
 function onHover(elem){
    elem.innerText = "Mon nouveau titre";
 }

 function onOut(elem){
    elem.innerText = "Mon ancien titre";
 }


 function addEvents(){

   let ids = ['title3', 'title4'];

   document.getElementById('title3').addEventListener('mouseover', function(e){
      onHover(this);
   })
   document.getElementById('title3').addEventListener('mouseout', function(e){
      onOut(this);
   })
   document.getElementById('title4').addEventListener('mouseover', function(e){
      onHover(this);
   })
   document.getElementById('title4').addEventListener('mouseout', function(e){
      onOut(this);
   })
 }

 window.onload = addEvents;


 function oneClick(elem){
   elem.innerText = "Vous avez cliqué une fois"
 }

 function doubleClick(elem){
   // let h1 = document.createElement('h1');
   // h1.innerText = "Vous avez cliqué 2 fois !";
   elem.innerHTML = "<h1>Vous avez cliqué 2 fois !</h1>"

}

/////////////////////////////////////////////////////////
//EX4
function moveButton(){

   let value = document.querySelector('input[type=text]').value;
   let button = document.querySelector('button');

   if(!value){
      if(!button.getAttribute('class')){
         button.setAttribute('class', 'ml-50');
      }else{
         button.className = "";
      }
   }
}
function putButtonBack(){   
   let button = document.querySelector('button');
   button.className = '';

}

