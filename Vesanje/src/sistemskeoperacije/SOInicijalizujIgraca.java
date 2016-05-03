package sistemskeoperacije;

import baza.Hangman;
import baza.Igraci;

public class SOInicijalizujIgraca {
	
	public static boolean izvrsi(String ime, Igraci igraci, int indexTrenutnogIgraca) {
		if (!igraci.daLiPostoji(ime)) {
			igraci.dodajIgraca(ime);
			return true;
		}
		indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
		return false;
	}

}
