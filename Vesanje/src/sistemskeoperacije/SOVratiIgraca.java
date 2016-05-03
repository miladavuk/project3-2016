package sistemskeoperacije;

import baza.Igrac;
import baza.Igraci;

public class SOVratiIgraca {
	
	public static Igrac izvrsi(Igraci igraci, int indexTrenutnogIgraca) {
		return igraci.vratiIgraca(indexTrenutnogIgraca);
	}

}
