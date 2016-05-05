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

/**
 * U ovoj klasi se nalaze osnovne operacije neophodne za uspesno izvrsavanje aplikacije.
 */
public class Hangman {
	/**
	 * Atribut predstavlja igrace koji igraju igricu.
	 */
	private Igraci igraci;
	/**
	 * Atribut predstavlja indeks igraca koji trenutno igra.
	 */
	private int indexTrenutnogIgraca;

	/**
	 * Metoda inicijalizuje igru.
	 */
	public Hangman() {
		igraci = new Igraci();
		indexTrenutnogIgraca = -1;
	}

	/**
	 * Metoda vraca boolean vredost koja pokazuje da li je kreiran novi
	 * igrac ili je pak uzet indeks igraca koji je ranije igrao.
	 * @param ime Ime igraca
	 * @ return boolean 
	 */
	public boolean incijalizujIgraca(String ime) {
		boolean b =  SOInicijalizujIgraca.izvrsi(ime, igraci);
		indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
		return b;
	}

	/**
	 * Metoda vraca igraca koji trenutno igra.
	 * @return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca)
	 */
	public Igrac vratiIgraca() {
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/**
	 * Metoda inicijalizuje igricu za odredjenog igraca.
	 * @param kategorija Kategorija reci
	 * @return SOPokreniPartiju.izvrsi(kategorija, igraci, indexTrenutnogIgraca)
	 */
	public char[] pokreniPartiju(String kategorija) {
		return SOPokreniPartiju.izvrsi(kategorija, igraci, indexTrenutnogIgraca);
	}

	/**
	 * Metoda koja vraca kategorije koje igrac moze da pogadja.
	 * @return SOVratiKategorije.izvrsi(igraci, indexTrenutnogIgraca)
	 */
	public String[] vratiKategorije() {
		return SOVratiKategorije.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/**
	 * Metoda cuva igrace iz liste.
	 */
	public void sacuvajIgrace() {
		SOSacuvajIgrace.izvrsi(igraci);
	}

	/**
	 * Metoda proverava da li je igrac izgubio.
	 * @return SODaLiJeIgracIzgubio.izvrsi(igraci, indexTrenutnogIgraca)
	 */
	public boolean daLiJeIgracIzgubio() {
		return SODaLiJeIgracIzgubio.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/**
	 * Metoda proverava da li je igrac pogodio celu rec.
	 * @return SODaLiJeIgracPogodioCeluRec.izvrsi(igraci, indexTrenutnogIgraca)
	 */
	public boolean daLiJeIgracPogodioCeluRec() {
		return SODaLiJeIgracPogodioCeluRec.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/**
	 * Metoda proverava da li se slovo nalazi u reci koja se trazi.
	 * @param slovo Slovo u reci
	 * @return SODodajSlovo.izvrsi(slovo, igraci, indexTrenutnogIgraca)
	 */
	public char[] dodajSlovo(char slovo) {
		return SODodajSlovo.izvrsi(slovo, igraci, indexTrenutnogIgraca);
	}

	/**
	 * Metoda vraca broj promasaja igraca.
	 * @return SOVratiBrojPromasaja.izvrsi(igraci, indexTrenutnogIgraca)
	 * 
	 */
	public int vratiBrojPromasaja() {
		return SOVratiBrojPromasaja.izvrsi(igraci, indexTrenutnogIgraca);
	}
}
