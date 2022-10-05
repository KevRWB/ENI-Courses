function changeTitleEnter(value){
    if(value == 'h1'){
        document.querySelector('#premierTitre').innerText = ('Nouveau titre');
    }else {
        document.querySelector('#secondTitre').innerText = ('Nouveau titre');
    }
    
}

function changeTitleLeave(value){
    if(value == 'h1'){
        document.querySelector('#premierTitre').innerText = ('Ancien titre');
    }else {
        document.querySelector('#secondTitre').innerText = ('Ancien titre');
    }
}