package baza;

public class Igrica {
	
	/**
	 * Atribut predstavlja rec za kojom igrac trazi.
	 */
	private String trazenaRec;
	/**
	 * Atribut pokazuje koliko puta je igrac promasio u odabiru slova ili
	 * pokusaju pogadjanja cele reci.
	 */
	private int brojPromasaja;

	/**
	 * Atribut predstavlja indeks reci u nizu kategorije kojoj pripada.
	 */
	private char[] recZaPrikazNiz;

	/**
	 * @param trazenaRec
	 * 
	 * Kontstruktor inicijalizuje klasu i uvodi novu trazenu rec, pocinje da
	 * broji broj promasaja i inicijalizuje rec koja ce biti prikazana nakon
	 * pokusaja pogadjanja.
	 */
	public Igrica(String trazenaRec) {
		this.trazenaRec = trazenaRec;
		brojPromasaja = 0;
		recZaPrikazNiz = vratiRecZaPrikaz();
	}

	/**
	 * @return trazenaRec
	 * Metoda vraca rec za kojom igrac traga.
	 */
	public String getTrazenaRec() {
		return trazenaRec;
	}

	/**
	 * @return brojPromasaja
	 * Metoda vraca broj promasaja u pogadjanju igraca.
	 */
	public int getBrojPromasaja() {
		return brojPromasaja;
	}


	/**
	 * @return recZaPrikaz.toCharArray()
	 * Metoda vraca rec za prikaz nakon inicijalizacije igrice.	 * 
	 * Nakon sto igrica otpocne sa radom i sto se odredi pojam za kojim se
	 * traga, napravi se niz koji se sastoji od zvezdica na mestima gde su slova
	 * koji ce biti prikazan igracu pri inicijalizaciji da pokaze koliko rec
	 * slova ima.
	 */

	public char[] vratiRecZaPrikaz() {
		String recZaPrikaz = "";

		for (int i = 0; i < trazenaRec.length(); i++) {
			if (trazenaRec.charAt(i) != ' ')
				recZaPrikaz += '*';
			else
				recZaPrikaz += ' ';
		}
		return recZaPrikaz.toCharArray();
	}

	/**
	 * @param slovo 	
	 * @return recZaPrikazNiz.
	 * 
	 * Metoda proverava da li se na nekom mestu u nizu karaktera koji je
	 * prosledjen kao parametar nalazi slovo koje je takodje prosledjeno kao
	 * parameter. Ukoliko jeste, onda se vrednost elemenata na tim mestima u
	 * nizu menja na to slovo i na kraju metoda vraca izmenjenu rec za prikaz u
	 * obliku niza.
	 */
	public char[] dodajSlovo(char slovo) {
		if (trazenaRec.toUpperCase().indexOf(slovo) != -1) {
			for (int i = 0; i < trazenaRec.toUpperCase().length(); i++) {
				if (trazenaRec.toUpperCase().charAt(i) == slovo) {
					recZaPrikazNiz[i] = slovo;
				}
			}
			return recZaPrikazNiz;
		} else {
			povecajBrojPromasaja();
			return new char[0];
		}

	}

	// Marina: Bio je ovde bag, recZaPrikazNiz kad se konvertuje
	// u String daje adresu, a ne taj string
	// if
	// (String.copyValueOf(recZaPrikazNiz).toUpperCase().equals(igrica.getTrazenaRec().toUpperCase()))
	// {
	// igrica.igracJePobedio();
	// btnOk.setVisible(false);
	// setVisible(false);
	// dispose();
	// }
	// }

	/**	 
	 * Ukoliko je rec koju je korisnik uneo jednaka trazenoj reci(pojmu) onda
	 * metoda vraca true, a u suprotnom vraca false.
	 * @return boolean
	 */
	public boolean daLiJePogodioCeluRec() {
		for (int i = 0; i < recZaPrikazNiz.length; i++) {
			if (recZaPrikazNiz[i] == '*')
				return false;
		}
		return true;
	}

	/**
	 * @param text 	 
	 * Metoda proverava, bez obaziranja na velika i mala slova, da li je uneti
	 * tekst jednak pojmu koji se trazi. Ako jeste, metoda vraca true, a u
	 * suprotnom vraca false.
	 * @return boolean
	 */
	public boolean probajOdjednom(String text) {
		if (text.equalsIgnoreCase(trazenaRec))
			return true;
		else {
			povecajBrojPromasaja();
			return false;
		}
	}

	/**
	 * U slucaju da je broj promasaja jednak 6 onda metoda vraca true, jer je
	 * igrac izgubio, a u suprotnom vraca false jer igrac ima pravo jos da traga
	 * za pojmom.
	 * @return boolean
	 */

	public boolean daLiJeIzgubio() {
		if (getBrojPromasaja() >= 6) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda povecava broj promasaja za 1.
	 */
	public void povecajBrojPromasaja() {
		brojPromasaja++;
	}
}
