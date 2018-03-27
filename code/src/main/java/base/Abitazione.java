package base;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Abitazione {

	public Abitazione(String identificativo, String via, String nCiv,String comune, double prezzo) {
		this.identificativo = identificativo;
		this.via = via;
		this.nCiv = nCiv;
		this.comune = comune;
		this.prezzo = prezzo;
		this.proprietari = new ArrayList<Proprietario>();
	}

	@Override
	public String toString() {
		return "Abitazione{" +
				"identificativo='" + identificativo + '\'' +
				", via='" + via + '\'' +
				", nCiv='" + nCiv + '\'' +
				", comune='" + comune + '\'' +
				", prezzo=" + prezzo +
				", proprietari=" + proprietari +
				'}';
	}

	public void addProprietario(Proprietario prop) {
		this.proprietari.add(prop);
	}

	public ArrayList<Proprietario> getProprietari() {
		return proprietari;
	}

	public void printProprietari(PrintStream ps) {
		for (Proprietario p : proprietari) {
			p.print(ps);
		}
	}

	public void printProprietari() {
		this.printProprietari(System.out);
	}

	public String getIdentificativo() {
		return identificativo;
	}

	public String getVia() {
		return via;
	}

	public String getnCiv() {
		return nCiv;
	}

	public String getComune() {
		return comune;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void print(PrintStream ps) {
		ps.println(identificativo);
		ps.println(via);
		ps.println(nCiv);
		ps.println(comune);
		ps.println(prezzo);
	}

	public void print() {
		this.print(System.out);
	}

	private String identificativo, via, nCiv, comune;
	private double prezzo;
	private ArrayList<Proprietario> proprietari;
}
