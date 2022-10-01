/*
@title : Script conjecture de Syracuse
@author : Kevin Renault
@Date : 23/09/2022
*/

/**
 * Algo conjecture Syracuse
 * 
 */

function algoConjSyracuse(nb){
    let listNumbers = new Array();
    let nbIteration = 1;

    while (nb != 1) {
        if (nb % 2 == 0) {
            nb /= 2;
        } else {
            nb = nb * 3 + 1;
        }
        let tempArray = [nbIteration, nb];
        listNumbers.push(tempArray);
        nbIteration ++;
    }
    return listNumbers;   
}

/**
 * Fonction affichage graphique des valeur prise par le nombre selectionné lors des calculs de la fonction "conjecture de Syracuse"
 * 
 */
function algoSyracuse(){
    //Get the value from user input
    let nbUser = document.getElementById("nbChoosen").value;
    console.log("Nombre selectionné "+ nbUser);

    //call the function to calculate algo
    let listNumbers = algoConjSyracuse(nbUser);

    //Add names of fields for chart
    listNumbers.unshift(["Iteration", "Number value"]);


    //call the google chart api
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    
    function drawChart() {
        let data = google.visualization.arrayToDataTable(listNumbers);
    
        let options = {
            title: 'Syracuse Conjecture',
            hAxis: {title: 'Iterations',  titleTextStyle: {color: '#333'}, minValue:1},
            vAxis: {minValue: 0}
        };
    
        let chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }


    //créer une liste HTML avec les element la liste de nombres
    document.getElementById("nbDepart").innerHTML = nbUser;

    listNumbers.forEach(element => {
        if(element[0] == "Iteration"){}
        else{
            let li = document.createElement("li");
            li.appendChild(document.createTextNode("Passage n°" + element[0] + " Valeur : " + element[1]));
            document.getElementById("nbList").appendChild(li);
        }
      
    });
    

}
