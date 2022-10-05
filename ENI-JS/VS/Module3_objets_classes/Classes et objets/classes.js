/**
 * Classes Course JS - ENI
 * 
 */

//Create class Animal
class Animal{
    constructor(name, type){
        this.name = name || "Roger";
        this.type = type || "Poivrot";
    }

    cry(cry){
        console.log(`${this.name} fait ${cry}`);
    }
}

//create instance
let dog = new Animal("Rex", "Dog");
let defaultAnimal = new Animal();
dog.cry("Wouaha");

/////////////////////
//HERITAGE

class Human extends Animal{
    constructor(name, type, secu){
        super(name, type);
        this.secu = secu;
    }
    getSecu(){
        console.log("Le numero de secu est " + this.secu);
    }
}

//create instance
let guy = new Human("Roger", "Human", 354354354);
console.log(guy);