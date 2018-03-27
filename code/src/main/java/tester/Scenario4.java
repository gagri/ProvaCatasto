package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import base.Proprietario;

public class Scenario4 {

	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scProp=new Scanner(new File("proprietari.txt"));
		Proprietario prop1=Proprietario.read(scProp);
		//prop1.print();

	}

}
