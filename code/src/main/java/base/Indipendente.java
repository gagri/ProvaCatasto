package base;

import java.io.PrintStream;
import java.util.Scanner;

public class Indipendente extends Abitazione {

	public Indipendente(String identificativo, String via, String nCiv,
			String comune, int nPiani, boolean giardino, double prezzo) {
		super(identificativo, via, nCiv, comune, prezzo);
		this.giardino = giardino;
		this.nPiani = nPiani;
	}

	public int getnPiani() {
		return nPiani;
	}

	public boolean isGiardino() {
		return giardino;
	}

	public void print(PrintStream ps) {
		ps.println(super.getIdentificativo());
		ps.println(super.getVia());
		ps.println(super.getnCiv());
		ps.println(super.getComune());
		ps.println(nPiani);
		ps.println(giardino);
		ps.println(super.getPrezzo());
	}

	public void print() {
		this.print(System.out);
	}

	public static Indipendente read(Scanner sc) {
		String identificativo, via, nCiv, comune;
		int nPiani;
		boolean giardino;
		double prezzo;
		if (!sc.hasNextLine()) {
			return null;
		}
		identificativo = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		via = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		nCiv = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		comune = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		String nPianis = sc.nextLine();
		nPiani = Integer.parseInt(nPianis);
		if (!sc.hasNextLine()) {
			return null;
		}
		String giardinos = sc.nextLine();
		if (giardinos.equalsIgnoreCase("true")) {
			giardino = true;
		} else {
			giardino = false;
		}
		if (!sc.hasNextLine()) {
			return null;
		}
		String prezzos = sc.nextLine();
		try {
			prezzo = Double.parseDouble(prezzos);
		} catch (NumberFormatException e) {
			int lunghezzaStringa = prezzos.length();
			String dec = prezzos.substring(lunghezzaStringa - 2, lunghezzaStringa);
			String intero = prezzos.substring(0, lunghezzaStringa - 4);
			prezzos = intero + "." + dec;
			prezzo = Double.parseDouble(prezzos);
		}

		return new Indipendente(identificativo, via, nCiv, comune, nPiani,
				giardino, prezzo);
	}

	private int nPiani;
	private boolean giardino;
}
