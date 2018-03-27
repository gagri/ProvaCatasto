package base;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestore {

	private Gestore(ArrayList<Abitazione> abitazioni,ArrayList<Proprietario> proprietari) {
		this.abitazioni = abitazioni;
		this.proprietari = proprietari;
	}

	public Gestore(Scanner scAb, Scanner scProp, Scanner scPropAb) {

		abitazioni = new ArrayList<Abitazione>();

		String tipo;

		while (scAb.hasNextLine()) {
			tipo = scAb.nextLine();

			if (tipo.equalsIgnoreCase("appartamento")) {
				Appartamento tmp = Appartamento.read(scAb);
				abitazioni.add(tmp);
			}
			if (tipo.equalsIgnoreCase("indipendente")) {
				Indipendente tmp = Indipendente.read(scAb);
				abitazioni.add(tmp);
			}

		}
		proprietari = new ArrayList<Proprietario>();
		while (scProp.hasNextLine()) {
			Proprietario tmp = Proprietario.read(scProp);
			proprietari.add(tmp);

		}
		ProprietarioAbitazione propAb;
		Abitazione abTmp;
		Proprietario propTmp;
		while (scPropAb.hasNextLine()) {
			propAb = ProprietarioAbitazione.read(scPropAb);
			propTmp = this.cercaPerCodFis(propAb.getCodFis());
			abTmp = this.cercaPerIdentificativo(propAb.getIdentificativo());
			propAb.setAbitazione(abTmp);
			propAb.setProprietario(propTmp);
			propTmp.addAbitazione(abTmp);
			abTmp.addProprietario(propTmp);
		}
	}

	public void printAbitazioni(PrintStream ps) {
		for (Abitazione ab : abitazioni) {
			if (ab instanceof Appartamento){
				Appartamento app=(Appartamento) ab;
				app.print(ps);
			}
				
			if (ab instanceof Indipendente){
				Indipendente ind=(Indipendente) ab;
				ind.print(ps);
			}
		}
	}

	public void printAbitazioni() {
		this.printAbitazioni(System.out);

	}

	public void printProprietari(PrintStream ps) {
		for (Proprietario ab : proprietari) {
			ab.print(ps);
		}
	}

	public void printProprietari() {
		this.printProprietari(System.out);

	}
	public void print(PrintStream ps){
		this.printAbitazioni(ps);
		ps.println("***********");
		this.printProprietari(ps);
	}
	public void print(){
		this.print(System.out);
	}
	
	public Proprietario cercaPerCodFis(String CodFis) {
		int a = 0;
		boolean trovato = false;
		Proprietario prop;
		while (!trovato && a < proprietari.size()) {
			prop = proprietari.get(a);
			if (prop.getCodFis().equalsIgnoreCase(CodFis)) {
				trovato = true;
				return prop;
			} else {
				a++;
			}
			
		}
		return null;
	}

	public Abitazione cercaPerIdentificativo(String identificativo) {
		int a = 0;
		boolean trovato = false;
		Abitazione ab;
		while (!trovato && a < abitazioni.size()) {
			ab = abitazioni.get(a);
			if (ab.getIdentificativo().equalsIgnoreCase(identificativo)) {
				trovato = true;
				return ab;
			} else {
				a++;
			}
			
		}
		return null;
	}

	
	public Gestore filtroPerComune(String comune) {
		ArrayList<Abitazione> tmp = new ArrayList<Abitazione>();
		ArrayList<Proprietario> tmp2 = new ArrayList<Proprietario>();
		for (Abitazione ab : abitazioni) {
			if (ab.getComune().equalsIgnoreCase(comune)) {
				tmp.add(ab);
				tmp2.addAll(ab.getProprietari());
			}
		}
		return new Gestore(tmp, tmp2);

	}

	public Gestore filtroPerVia(String via) {
		ArrayList<Abitazione> tmp = new ArrayList<Abitazione>();
		ArrayList<Proprietario> tmp2 = new ArrayList<Proprietario>();
		for (Abitazione ab : abitazioni) {
			if (ab.getVia().equalsIgnoreCase(via)) {
				tmp.add(ab);
				tmp2.addAll(ab.getProprietari());
			}
		}
		
		return new Gestore(tmp, tmp2);
	}
	public Gestore filtroPerLuogoNascita(String comune) {
		ArrayList<Abitazione> tmp = new ArrayList<Abitazione>();
		ArrayList<Proprietario> tmp2 = new ArrayList<Proprietario>();
		for (Proprietario prop : proprietari) {
			if (prop.getLuogoNascita().equalsIgnoreCase(comune)) {
				
				tmp2.add(prop);
				tmp.addAll(prop.getAbitazioni());
			}
		}
		
		return new Gestore(tmp, tmp2);

	}
	public Gestore filtroAppartamenti() {
		ArrayList<Abitazione> tmp = new ArrayList<Abitazione>();
		ArrayList<Proprietario> tmp2 = new ArrayList<Proprietario>();
		for (Abitazione a:abitazioni) {
			if (a instanceof Appartamento) {
			tmp.add(a);
			}
		}
		
		return new Gestore(tmp, tmp2);
	}
	public Gestore filtroIndipendenti() {
		ArrayList<Abitazione> tmp = new ArrayList<Abitazione>();
		ArrayList<Proprietario> tmp2 = new ArrayList<Proprietario>();
		for (Abitazione a:abitazioni) {
			if (a instanceof Indipendente) {
			tmp.add(a);
			}
		}
		return new Gestore(tmp, tmp2);
	}
	private ArrayList<Abitazione> abitazioni;
	private ArrayList<Proprietario> proprietari;
}
