/**
 * Creation d'un fenetre d'alert - JS
 * 
 */

 function unMessage() { 
    window.open("Alert.html", 
    "alerte", 
    "width=300, height=100, location=no, menubar=no, status=no, toolbar=no, scrollbars=no, resizable=no, left=250, top= 500");
 }

//  unMessage()

///// test onclick listener
let title = document.getElementById('title');
title.addEventListener("click", boutonClique);
// 
function boutonClique(){
    alert('Clique sur le titre');
}

