/**
 * TP API Villes
 * 
 */
////////////////   datas
let datas;

/////////////////////////////////////////////////
function fillSelect(){
    let depNo;

    depNo = document.getElementById("searchInput").value;
    if(depNo.length < 2){
        depNo = "0" + depNo;
    }

    fetch(`https://geo.api.gouv.fr/departements/${depNo}/communes`).then(response => response.json()).then(data => useData(data)).catch((error) => gestionError(error));
    
}

/////////////////////////////////////////////////
function useData(data){
    console.log(data);
    let selectHtml =  document.getElementById("selectCP");
    //reset select
    selectHtml.innerHTML = "";
    for (const ville of data) {
      
        let option = document.createElement('option');
        option.innerText = ville.nom;
        option.value = ville.nom;
        selectHtml.appendChild(option);
        datas = data;
    }
}

/////////////////////////////////////////////
function printCity(elem){
    let nomVille = elem.value
    let container = document.getElementById('container');
    container.innerHTML="";

    for (const ville of datas) {
        if(nomVille == ville.nom){
            let div = document.createElement('div');
            let nameVille = document.createElement("h2");
            let cpVilleTxt = document.createElement("p");
            let cpVille = document.createElement("ul");

            for (const cp of ville.codesPostaux) {
                let li = document.createElement("li");
                li.innerText = cp;
                cpVille.appendChild(li);
            }

            let population = document.createElement("p");

            nameVille.innerText = ville.nom;
            cpVilleTxt.innerText = 'Code Postaux :';
            population.innerText = 'Population : ' +  ville.population;

            div.appendChild(nameVille);
            div.appendChild(cpVilleTxt);
            div.appendChild(cpVille);
            div.appendChild(population);

            container.appendChild(div);
            
        }
    }
    document.body.appendChild(container);
}

/////////////////////////////////////////
function gestionError(error){
    alert("Code postal inconnu");

}



