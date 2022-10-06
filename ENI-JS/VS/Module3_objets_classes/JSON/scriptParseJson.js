fetch('data.json').then(response => response.json()).then(data => useData(data));

///////////////////////////////////////////////////////////
function useData(data){
    let elves = data.la_communaute_de_l_anneau.elfes;
    let hobbits = data.la_communaute_de_l_anneau.hobbits;

    addElves(elves);
    addHobbits(hobbits);

    console.log(Object.keys(data));
}

///////////////////////////////////////////////////////////
function addElves(elves){
    let h1 = document.createElement('h1');
    h1.innerText = "Elfes";

    let div = document.createElement('div');
    div.appendChild(h1);

    for (const elf of elves) {
        
        let p = document.createElement('p');
        p.innerText = `${elf.nom} : Age : ${elf.age} - Arme : ${elf.arme}`;
        div.appendChild(p);
    }

    document.body.appendChild(div);
}
/////////////////////////////////////////////////////////////
function addHobbits(hobbits){
    let h1 = document.createElement('h1');
    h1.innerText = "Hobbits";

    let div = document.createElement('div');
    div.appendChild(h1);

    for (const hobbit of hobbits) {
        
        let p = document.createElement('p');
        p.innerText = `${hobbit}`;
        div.appendChild(p);
    }

    document.body.appendChild(div);
}


