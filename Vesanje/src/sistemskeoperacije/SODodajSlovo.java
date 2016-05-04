package sistemskeoperacije;

import baza.Igraci;

public class SODodajSlovo {
	/*
	 * @param Slovo za koje se proverava da li se nalazi u reci.
	 * 
	 * @param igraci Lista igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca koji trenutno igra.
	 * 
	 * @return Metoda poziva metodu koja proverava da li se u reci nalazi slovo.
	 */
	public static char[] izvrsi(char slovo, Igraci igraci, int indexTrenutnogIgraca) {

		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().dodajSlovo(slovo);
	}

}
