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
	
	public boolean daLiJeIgracIzgubio(){
		return vratiIgraca().getIgrica().daLiJeIzgubio();
	}
	
	public boolean daLiJeIgracPogodioCeluRec(){
		return vratiIgraca().getIgrica().daLiJePogodioCeluRec();
	}
	
	public char [] dodajSlovo(char slovo){
		return vratiIgraca().getIgrica().dodajSlovo(slovo);
	}
	
	public int vratiBrojPromasaja(){
		return vratiIgraca().getIgrica().getBrojPromasaja();
	}
}
