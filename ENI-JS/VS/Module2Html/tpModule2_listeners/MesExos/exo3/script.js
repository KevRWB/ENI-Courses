function oneClick(){
    console.log("Vous avez cliqué 1 fois");
}

function dblClick(){
   let h1 =  document.createElement('h1');
   h1.innerText = 'Vous avez cliqué 2 fois';
   document.body.appendChild(h1);
}