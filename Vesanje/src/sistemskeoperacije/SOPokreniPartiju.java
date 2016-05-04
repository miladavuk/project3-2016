package sistemskeoperacije;

import baza.Igraci;

public class SOPokreniPartiju {
	/*
	 * @param kategorija Kategorija koju pogadja igrac.
	 * 
	 * @param igraci Lista igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca koji trenutno igra.
	 * 
	 * @return Metoda inicijalizuje igricu za igraca koji trenutno igra i
	 * postavlja da bira rec iz kategorije koja je uneta kao parametar.
	 */
	public static char[] izvrsi(String kategorija, Igraci igraci, int indexTrenutnogIgraca) {
		return igraci.vratiIgraca(indexTrenutnogIgraca).pokreniIgricu(kategorija);
	}

}
