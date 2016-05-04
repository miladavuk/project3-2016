package sistemskeoperacije;

import baza.Igraci;

public class SODaLiJeIgracIzgubio {
	/*
	 * @param igraci Lista igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca koji trenutno igra.
	 * 
	 * @return Poziva metodu koja proverava da li je igrac izgubio.
	 */
	public static boolean izvrsi(Igraci igraci, int indexTrenutnogIgraca) {
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().daLiJeIzgubio();
	}

}
