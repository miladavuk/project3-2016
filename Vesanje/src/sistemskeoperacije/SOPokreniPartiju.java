package sistemskeoperacije;

import baza.Igraci;

public class SOPokreniPartiju {
	
	public static char [] izvrsi(String kategorija,Igraci igraci, int indexTrenutnogIgraca) {
		return igraci.vratiIgraca(indexTrenutnogIgraca).pokreniIgricu(kategorija);
	}

}
