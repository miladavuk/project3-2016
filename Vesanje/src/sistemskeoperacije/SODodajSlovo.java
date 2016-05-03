package sistemskeoperacije;

import baza.Igraci;

public class SODodajSlovo {
	
	public static char [] izvrsi(char slovo, Igraci igraci, int indexTrenutnogIgraca){
		
		return SOVratiIgraca.izvrsi(igraci, indexTrenutnogIgraca).getIgrica().dodajSlovo(slovo);
	}
	

}
