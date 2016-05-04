package sistemskeoperacije;

import baza.Igraci;

public class SOVratiBrojPromasaja {
	/*
	 * @param igraci Lista svih igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca u listi igraca.
	 * 
	 * @return Metoda vraca broj promasaja igraca koji trenutno igra.
	 */
	public static int izvrsi(Igraci igraci, int indexTrenutnogIgraca) {
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().getBrojPromasaja();
	}

}
