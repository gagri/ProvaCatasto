package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import base.Abitazione;
import base.Appartamento;
import base.Indipendente;

public class Scenario2 {

	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scAb=new Scanner(new File("soluzioni.txt"));
		String tipo=scAb.nextLine();
		if(tipo.equalsIgnoreCase("appartamento")){
			Abitazione ab=Appartamento.read(scAb);
			ab.print();
			System.out.println(ab);
		}
		
		/*if(tipo.equalsIgnoreCase("indipendente")){
			Abitazione ab2=Appartamento.read(scAb);
			ab2.print();
		}
		String tipo2=scAb.nextLine();
		if(tipo2.equalsIgnoreCase("appartamento")){
			Abitazione ab=Appartamento.read(scAb);
			ab.print();
		}
		if(tipo2.equalsIgnoreCase("indipendente")){
			Abitazione ab2=Indipendente.read(scAb);
			ab2.print();
		}*/
	}

}
