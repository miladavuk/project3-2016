package baza;

import sistemskeoperacije.SODaLiJeIgracIzgubio;
import sistemskeoperacije.SODaLiJeIgracPogodioCeluRec;
import sistemskeoperacije.SODodajSlovo;
import sistemskeoperacije.SOInicijalizujIgraca;
import sistemskeoperacije.SOPokreniPartiju;
import sistemskeoperacije.SOSacuvajIgrace;
import sistemskeoperacije.SOVratiBrojPromasaja;
import sistemskeoperacije.SOVratiIgraca;
import sistemskeoperacije.SOVratiKategorije;

public class Hangman {
	private Igraci igraci;
	private int indexTrenutnogIgraca;
	
	public Hangman(){
		igraci = new Igraci();
		indexTrenutnogIgraca = -1;
	}
	
	public boolean incijalizujIgraca(String ime) {
		return SOInicijalizujIgraca.izvrsi(ime, igraci, indexTrenutnogIgraca);
	}

	public Igrac vratiIgraca() {
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca);
	}

	public char [] pokreniPartiju(String kategorija) {
		return SOPokreniPartiju.izvrsi(kategorija, igraci, indexTrenutnogIgraca);
	}
	
	public String [] vratiKategorije(){
		return SOVratiKategorije.izvrsi(igraci, indexTrenutnogIgraca);
	}

	public void sacuvajIgrace() {
		SOSacuvajIgrace.izvrsi(igraci);
	}
	
	public boolean daLiJeIgracIzgubio(){
		return SODaLiJeIgracIzgubio.izvrsi(igraci, indexTrenutnogIgraca);
	}
	
	public boolean daLiJeIgracPogodioCeluRec(){
		return SODaLiJeIgracPogodioCeluRec.izvrsi(igraci, indexTrenutnogIgraca);
	}
	
	public char [] dodajSlovo(char slovo){
		return SODodajSlovo.izvrsi(slovo, igraci, indexTrenutnogIgraca);
	}
	
	public int vratiBrojPromasaja(){
		return SOVratiBrojPromasaja.izvrsi(igraci, indexTrenutnogIgraca);
	}
}
