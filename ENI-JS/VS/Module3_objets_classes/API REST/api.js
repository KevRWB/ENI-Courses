/**
 * Script API REST
 * 
 */

// get datas from API StarWars
// fetch("https://swapi.dev/api/species").then(response => response.json()).then(species => console.log(species));


async function callApi(){
    // Stocke la promesse
    let response = await fetch("https://swapi.dev/api/species");
    console.log(response);
    if(response.ok){
       return response.json();
    }
    
}

async function useApi(){
    let species = await callApi();
    console.log(species);
}

useApi();
