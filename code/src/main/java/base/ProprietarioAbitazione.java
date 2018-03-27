package base;

import java.util.Scanner;

public class ProprietarioAbitazione {

	public ProprietarioAbitazione(String codFis, String identificativo) {
		this.codFis = codFis;
		this.identificativo = identificativo;
		this.proprietario=null;
		this.abitazione=null;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Abitazione getAbitazione() {
		return abitazione;
	}

	public void setAbitazione(Abitazione abitazione) {
		this.abitazione = abitazione;
	}

	public String getCodFis() {
		return codFis;
	}

	public String getIdentificativo() {
		return identificativo;
	}
	public static ProprietarioAbitazione read (Scanner sc){
		String codFis,identificativo;
	
		if(!sc.hasNextLine()){ 
			return null;
		}
		codFis=sc.nextLine();
		if(!sc.hasNextLine()){ 
			return null;
		}
		identificativo=sc.nextLine();
		return new ProprietarioAbitazione(codFis,identificativo);
	}
	private String codFis,identificativo;
	private Proprietario proprietario;
	private Abitazione abitazione;
}
