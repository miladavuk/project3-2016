package sistemskeoperacije;

import baza.Igraci;

public class SOVratiKategorije {

	public static String [] izvrsi(Igraci igraci, int indexTrenutnogIgraca){
		return igraci.vratiIgraca(indexTrenutnogIgraca).vratiKategorije();
	}
}
