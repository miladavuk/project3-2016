package sistemskeoperacije;

import baza.Igraci;

public class SODaLiJeIgracPogodioCeluRec {
	/*
	 * @param igraci Lista igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca koji trenutno igra.
	 * 
	 * @return Poziva metodu koja proverava da li je igrac pogodio celu rec.
	 */
	public static boolean izvrsi(Igraci igraci, int indexTrenutnogIgraca) {
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().daLiJePogodioCeluRec();
	}

}
