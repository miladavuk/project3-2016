package sistemskeoperacije;

import baza.Igrac;
import baza.Igraci;

public class SOVratiIgraca {
	/*
	 * @param igraci Lista igraca koji su igrali.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca koji sada igra.
	 * 
	 * @return Metoda vraca igraca koji trenutno igra.
	 */
	public static Igrac izvrsi(Igraci igraci, int indexTrenutnogIgraca) {
		return igraci.vratiIgraca(indexTrenutnogIgraca);
	}

}
