/**
 * CLOSURE
 * 
 */

const affichageDuMetier = function(){
    let metier = "Développeur";

    return function(val = metier){ // valeur par default
        //affichage des valeurs
        console.log("Le métier est " + metier);
        console.log("Le parametre est " + val);
        //
        if(val != metier){
            metier = val;
        }

        console.log("Le nouveau métier est " + metier);
    }
}

//stockage de le valeur de retour de la fonction dans une variable
let quelMetier = affichageDuMetier();

//appel de la fonction avec un parametre
quelMetier("Routier");
