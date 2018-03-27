package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import base.Abitazione;
import base.Gestore;
import base.Proprietario;

public class Scenario3 {
	public static void main (String[] args) throws FileNotFoundException{
		
		Scanner scAb=new Scanner(new File("soluzioni.txt"));
		Scanner scProp=new Scanner(new File("proprietari.txt"));
		Scanner scPropAb=new Scanner(new File("proprieta.txt"));
		Gestore gest=new Gestore(scAb, scProp, scPropAb);
		
	
		Abitazione app=gest.cercaPerIdentificativo("89ind");
		app.printProprietari();
		
		System.out.println("****************");
		Abitazione app2=gest.cercaPerIdentificativo("23app");
		app2.printProprietari();
		
		System.out.println("****************");
		Proprietario prop=gest.cercaPerCodFis("ZZZPSQ83G20");
		prop.printAbitazioni();
}
}