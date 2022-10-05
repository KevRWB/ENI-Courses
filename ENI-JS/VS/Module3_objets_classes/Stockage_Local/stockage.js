/**
 * Script cours stockage
 * 
 */

//////////////////////////  COOKIES
//creer un cookie
document.cookie = "prenom=Kevin";
document.cookie = "nom=qsdqfg";

//editer un cookie existant
document.cookie = "prenom=Michel";

//Lui donner une duree de vie
document.cookie = "prenom=Kevin; max-age=3600";

//get cookies
let cookies = document.cookie;

let eCookies = cookies.split("; ");

//////////////////////// LOCAL STORAGE
localStorage.setItem("age", 36);
localStorage.setItem("nom", "Dupont");

sessionStorage.setItem('cheveux', 'long');

let age = localStorage.getItem("age");
localStorage.removeItem("age");