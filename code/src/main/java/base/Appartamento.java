package base;

import java.io.PrintStream;
import java.util.Scanner;

public class Appartamento extends Abitazione {

	public Appartamento(String identificativo, String nomePalazzo, String via, String nCiv, String comune, String piano, int nStanze, double mQuadri, double prezzo) {
		super(identificativo, via, nCiv, comune, prezzo);
		this.nomePalazzo = nomePalazzo;
		this.piano = piano;
		this.nStanze = nStanze;
		this.mQuadri = mQuadri;
	}

	public String getNomePalazzo() {
		return nomePalazzo;
	}

	public String getPiano() {
		return piano;
	}

	public int getStanze() {
		return nStanze;
	}

	public double getmQuadri() {
		return mQuadri;
	}

	public void print(PrintStream ps) {
		ps.println(super.getIdentificativo());
		ps.println(nomePalazzo);
		ps.println(super.getVia());
		ps.println(super.getnCiv());
		ps.println(super.getComune());
		ps.println(piano);
		ps.println(nStanze);
		ps.println(mQuadri);
		ps.println(super.getPrezzo());

	}

	public void print() {
		this.print(System.out);
	}

	public static Appartamento read(Scanner sc) {
		String identificativo, nomePalazzo, via, nCiv, comune, piano;
		int nStanze;
		double mQuadri, prezzo;
		if (!sc.hasNextLine()) {
			return null;
		}
		identificativo = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		nomePalazzo = sc.nextLine();
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
		piano = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		String nStanzes = sc.nextLine();
		nStanze = Integer.parseInt(nStanzes);
		if (!sc.hasNextLine()) {
			return null;
		}
		String mQuadris = sc.nextLine();
		mQuadri = Double.parseDouble(mQuadris);
		if (!sc.hasNextLine()) {
			return null;
		}
		String prezzos = sc.nextLine();
		try {
			prezzo = Double.parseDouble(prezzos);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.err.println("errore nel formato del prezzo dell'abitazione: "+identificativo);
			System.err.println("il prezzo sara corretto");
			int lunghezzaStringa = prezzos.length();
			String dec = prezzos.substring(lunghezzaStringa - 2, lunghezzaStringa);
			String intero = prezzos.substring(0, lunghezzaStringa - 4);
			prezzos = intero + "." + dec;
			prezzo = Double.parseDouble(prezzos);
		}
		return new Appartamento(identificativo, nomePalazzo, via, nCiv, comune,	piano, nStanze, mQuadri, prezzo);
	}

	private String nomePalazzo, piano;
	private int nStanze;
	private double mQuadri;
}
