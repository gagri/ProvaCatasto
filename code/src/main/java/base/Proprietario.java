package base;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Proprietario {

	public Proprietario(String codFis, String cognome, String nome,
			Date dataNascita, String luogoNascita) {

		this.codFis = codFis;
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.abitazioni=new ArrayList<Abitazione>();
	}

	public void addAbitazione(Abitazione ab){
		this.abitazioni.add(ab);
	}
	public ArrayList<Abitazione> getAbitazioni(){
		return abitazioni;
	}
	public void printAbitazioni(PrintStream ps){
		for (Abitazione a : abitazioni){
			a.print(ps);
		}
	}
	public void printAbitazioni(){
		this.printAbitazioni(System.out);
	}
	public void print(PrintStream ps) {
		ps.println(codFis);
		ps.println(cognome);
		ps.println(nome);
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		String data=df.format(dataNascita);
		ps.println(data);
		ps.println(luogoNascita);
	}

	public String getCodFis() {
		return codFis;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void print() {
		this.print(System.out);
	}

	public static Proprietario read(Scanner sc) {
		String codFis, cognome, nome, dataNascita, luogoNascita;
		if (!sc.hasNextLine()) {
			return null;
		}
		codFis = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		cognome = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		nome = sc.nextLine();
		if (!sc.hasNextLine()) {
			return null;
		}
		
		dataNascita = sc.nextLine();
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date oggi=new Date();
		Date nascita;
		try{
		nascita=df.parse(dataNascita);
		if(nascita.after(oggi)){
			throw new InvalidDateException("la data di nascita e superiore a quella odierna");
		}
		}catch(ParseException e){
			System.err.println("Riscontrato errore nel parsing della data di nascita di: "+codFis );
			System.err.println(e.getMessage());
			System.err.println("la data di nascita verra posta pari a quella odierna");
			nascita=oggi;
		}
		catch(InvalidDateException e){
			System.err.println("Riscontrato errore nella data di nascita di: "+codFis );
			System.err.println(e.getMessage());
			System.err.println("la data di nascita verra posta pari a quella odierna");
			nascita=oggi;
			
		}
		if (!sc.hasNextLine()) {
			return null;
		}
		luogoNascita = sc.nextLine();

		return new Proprietario(codFis, cognome, nome, nascita,
				luogoNascita);
	}

	private String codFis, cognome, nome, luogoNascita;
	private Date dataNascita;
	private ArrayList<Abitazione> abitazioni;
}
