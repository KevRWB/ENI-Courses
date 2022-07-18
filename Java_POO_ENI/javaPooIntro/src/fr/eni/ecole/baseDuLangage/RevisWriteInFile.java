package fr.eni.ecole.baseDuLangage;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RevisWriteInFile {
	//--Main programm
	public static void main(String[] args) {
	
		String[] tabAnimals = {"Marsouin", "Pingouin", "Lion"};
		//--Create and write on file
		try {
			writeFile(tabAnimals, "./animaux.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//--read file
		readFile("./animaux.txt");

	}
	//--Methods
	private static void writeFile(String[]tab, String file) throws IOException{
		//declare and init null FileWriter
		FileWriter fw = null;
		//init FileWriter with file to create or modify
			fw = new FileWriter(file);
		//Write in the file
		for (int i = 0; i < tab.length; i++) {	
				fw.write(String.format("%s%n", tab[i]));
			}
		System.out.println("Printing ok");
		
		fw.close();
	}

	//--Read file
	private static void readFile(String file) {
		
		try(
			FileInputStream f = new FileInputStream(file);
			Scanner s = new Scanner(f)){
			
			while(s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
			System.out.println("Fichier lu intégralement");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

