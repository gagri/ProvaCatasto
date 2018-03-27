package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import base.Gestore;

public class Scenario5 {

	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scAb=new Scanner(new File("soluzioni.txt"));
		Scanner scProp=new Scanner(new File("proprietari.txt"));
		Scanner scPropAb=new Scanner(new File("proprieta.txt"));
		Gestore gest=new Gestore(scAb, scProp, scPropAb);
		
		Gestore gest2= gest.filtroPerVia("via roma");
		gest2.print();
		
		
		

	}

}
