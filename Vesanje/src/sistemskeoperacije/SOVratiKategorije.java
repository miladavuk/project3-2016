package sistemskeoperacije;

import baza.Igraci;

public class SOVratiKategorije {
	/*
	 * @param igraci Lista igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca koji trenutno igra.
	 * 
	 * @return Metoda vraca niz kategorija koje igrac moze da pogadja.
	 * 
	 * Metoda vraca kategorije iz kojih igrac nije pogodio sve pojmove, sto
	 * znaci da moze da pogadja pojmove iz te kategorije.
	 */
	public static String[] izvrsi(Igraci igraci, int indexTrenutnogIgraca) {
		return igraci.vratiIgraca(indexTrenutnogIgraca).vratiKategorije();
	}
}
