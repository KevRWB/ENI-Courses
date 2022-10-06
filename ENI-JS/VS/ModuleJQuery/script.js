/**
 * Cours JQuery
 * 
 */

//Fonction cacher toutes les div
function hideAll(){
    $('div').hide();
}

//Fonction afficher toutes les div
function showAll(){
    jQuery('div').show(); // ecriture non utilisée
}

//fonction cacher le troisimeme marin
function hideThirdSailor(){
    $('.marin:last').hide();
    // $('.marin:eq(2)').hide(); //cible le 2eme element class "marin" (index commence à 0)
    $('.equipage').append('<h1>Sirènes</h1>');
}

//fonction qui ajoute la class "pirate" aux marins
function becomePirates(){
    $(".marin").toggleClass('pirate');

    //fonction qui boucle sur les element : callback en argumenet qui prends index + element en argument
    $(".marin").each(function (idx, val) { 
         console.log(idx);
         console.log(val);
         $(this).text("Super-marin" + idx);
    })  
}

//fonction qui ajoute un élèment marin 
function addSailor(){

    $('.equipage').append('<div class=marin>Marin en plus</div>');

}

//evenement click
$('#capitaine').click(function (e) { 
    e.preventDefault();
    
});

//autre évènement - supprime element bateau quand souris passe dessus
function addEvents(){
    $('.bateau').on("mouseover", function(){
        $(this).remove();
    })
    //delegation d'evenement -> ajoute le listener aux elements "marin" egalement
    $('.equipage').on('mouseover', '.marin', function(){ 
        $(this).toggleClass('pirate');
    })
}
//appel de la fonction
addEvents();

/// annule le comportement par default d'un evenement
$('a').click(function(event){
    event.preventDefault();
})

