package baza;

public class Hangman {
	private Igraci igraci;
	private int indexTrenutnogIgraca;
	
	public Hangman(){
		igraci = new Igraci();
	}
	
	public boolean incijalizujIgraca(String ime) {
		if (!igraci.daLiPostoji(ime)) {
			igraci.dodajIgraca(ime);
			indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime); // MARINA: Ove verovatno treba da ide u hangmana
			return true;
		}
		indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
		return false;
	}

	public Igrac vratiIgraca() {
		return igraci.vratiIgraca(indexTrenutnogIgraca);
	}

	public char [] pokreniPartiju(String kategorija) {
		return igraci.vratiIgraca(indexTrenutnogIgraca).pokreniIgricu(kategorija);
	}
	
	public String [] vratiKategorije(){
		return igraci.vratiIgraca(indexTrenutnogIgraca).vratiKategorije();
	}

	public void sacuvajIgrace() {
		igraci.serijalizujIgrace();
	}
}
