package sistemskeoperacije;

import baza.Igraci;

public class SOVratiBrojPromasaja {
	
	public static int izvrsi(Igraci igraci, int indexTrenutnogIgraca){
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().getBrojPromasaja();
	}

}
