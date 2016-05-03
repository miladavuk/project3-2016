package sistemskeoperacije;

import baza.Igraci;

public class SODaLiJeIgracPogodioCeluRec {
	
	public static boolean izvrsi(Igraci igraci, int indexTrenutnogIgraca){
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().daLiJePogodioCeluRec();
	}

}
