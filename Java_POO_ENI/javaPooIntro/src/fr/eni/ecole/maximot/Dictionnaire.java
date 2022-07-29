package fr.eni.ecole.maximot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionnaire {
	
	private String file;
	
	private static ArrayList<String> dictionnaire = new ArrayList<>();
	
	
	public Dictionnaire(String file) {
		this.file = file;
	}
	
	public void fillList(ArrayList<String> list) throws FileNotFoundException {
		FileInputStream fichier = new FileInputStream(file);
		Scanner s = new Scanner(fichier);
		
		while(s.hasNextLine()) {
			list.add(s.nextLine());
		}
	}
	
	public void printDico(ArrayList<String> list) {
		for(String item : list) {
			System.out.println(item);
		}
	}
	
	
	
	//GETTERS SETTERS
	public ArrayList<String> getDictionnaire() {
		return dictionnaire;
	}

	public void setDictionnaire(ArrayList<String> dictionnaire) {
		Dictionnaire.dictionnaire = dictionnaire;
	}
	

	
	
	
	
}
