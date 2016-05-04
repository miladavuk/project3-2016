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

/*
 * U ovoj klasi se nalaze osnovne operacije neophodne za uspesno izvrsavanje aplikacije.
 */
public class Hangman {
	/*
	 * Atribut predstavlja igrace koji igraju igricu.
	 */
	private Igraci igraci;
	/*
	 * Atribut predstavlja indeks igraca koji trenutno igra.
	 */
	private int indexTrenutnogIgraca;

	/*
	 * Metoda inicijalizuje igru.
	 */
	public Hangman() {
		igraci = new Igraci();
		indexTrenutnogIgraca = -1;
	}

	/*
	 * @return Metoda vraca boolean vredost koja pokazuje da li je kreiran novi
	 * igrac ili je pak uzet indeks igraca koji je ranije igrao.
	 */
	public boolean incijalizujIgraca(String ime) {
		return SOInicijalizujIgraca.izvrsi(ime, igraci, indexTrenutnogIgraca);
	}

	/*
	 * @return Metoda vraca igraca koji trenutno igra.
	 */
	public Igrac vratiIgraca() {
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/*
	 * @return Metoda inicijalizuje igricu za odredjenog igraca.
	 */
	public char[] pokreniPartiju(String kategorija) {
		return SOPokreniPartiju.izvrsi(kategorija, igraci, indexTrenutnogIgraca);
	}

	/*
	 * @return Metoda koja vraca kategorije koje igrac moze da pogadja.
	 */
	public String[] vratiKategorije() {
		return SOVratiKategorije.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/*
	 * Metoda cuva igrace iz liste.
	 */
	public void sacuvajIgrace() {
		SOSacuvajIgrace.izvrsi(igraci);
	}

	/*
	 * Metoda proverava da li je igrac izgubio.
	 */
	public boolean daLiJeIgracIzgubio() {
		return SODaLiJeIgracIzgubio.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/*
	 * Metoda proverava da li je igrac pogodio celu rec.
	 */
	public boolean daLiJeIgracPogodioCeluRec() {
		return SODaLiJeIgracPogodioCeluRec.izvrsi(igraci, indexTrenutnogIgraca);
	}

	/*
	 * @return Metoda proverava da li se slovo nalazi u reci koja se trazi.
	 */
	public char[] dodajSlovo(char slovo) {
		return SODodajSlovo.izvrsi(slovo, igraci, indexTrenutnogIgraca);
	}

	/*
	 * @return Metoda vraca broj promasaja igraca.
	 * 
	 */
	public int vratiBrojPromasaja() {
		return SOVratiBrojPromasaja.izvrsi(igraci, indexTrenutnogIgraca);
	}
}
