package baza;

public class Igrica {
	/*
	 * Atribut predstavlja rec za kojom igrac trazi.
	 */
	private String trazenaRec;
	/*
	 * Atribut pokazuje koliko puta je igrac promasio u odabiru slova ili
	 * pokusaju pogadjanja cele reci.
	 */
	private int brojPromasaja;

	/*
	 * Atribut predstavlja kategoriju za koju se odlucio igrac.
	 */

	/*
	 * Atribut predstavlja indeks reci u nizu kategorije kojoj pripada.
	 */
	private char [] recZaPrikazNiz;
	/*
	 * @param igrac Metodi se prosledjuje igrac koji trenutno igra.
	 * 
	 * Konstruktor postavlja vrednosti gore pomenutih atributa na odredjene
	 * vrednosti. trazenaRec postaje prazan String, igrac se postavlja na
	 * vrednost unetu kao parametar, a broj promasaja na 0, cime je
	 * inicijalizovana igrica.
	 */
	public Igrica(String trazenaRec) {
		this.trazenaRec = trazenaRec;
		brojPromasaja = 0;
		recZaPrikazNiz = vratiNizChar();
	}

	/*
	 * @return Metoda vraca rec za kojom igrac traga.
	 */
	public String getTrazenaRec() {
		return trazenaRec;
	}

	/*
	 * @return Metoda vraca broj promasaja u pogadjanju igraca.
	 */
	public int getBrojPromasaja() {
		return brojPromasaja;
	}

	// public LinkedList<Character> getKoriscenaSlova() {
	// return koriscenaSlova;
	// }

	// public int getBrojKoriscenihSlova() {
	// return brojKoriscenihSlova;
	// }

	/*
	 * @return Metoda vraca igraca koji pogadja.
	 */

	/*
	 * @param kategorija Metodi se prosledjuje kategorija za koju se odlucio
	 * igrac.
	 * 
	 * @return Metoda vraca String koji se sastoji od zvezdica na mestima gde su
	 * slova, dok prazna mesta ostaju prazna mesta.
	 * 
	 * Metoda kreira nov objekat klase Kategorija, koja je jednaka onoj
	 * kategoriji koju je igrac odabrao. Nakon toga, pomocu klase Random se
	 * kreira nasumican ceo broj koji se koristi kao indeks pojma u okviru niza
	 * pojmova odabrane kategorije (u klasi Kategorije). Potom se proverava
	 * koliko je pojmova igrac pogodio u okviru odabrane kategorije. Ukoliko je
	 * pogodio sve pojmove, metoda vraca String "greska", a u suprotnom se traga
	 * za pojmom koji igrac nije pogodio i vrednost atributa trazenaRec se
	 * postavlja na tu rec. Potom se kreira String sastavljen od * na mestima
	 * gde su slova u trazenoj reci i taj String se vraca kao povratna vrednost.
	 * 
	 */
	
	public char [] vratiNizChar() {
		String recZaPrikaz = "";
	
		for (int i = 0; i < trazenaRec.length(); i++) {
			if (trazenaRec.charAt(i) != ' ')
				recZaPrikaz += '*';
			else
				recZaPrikaz += ' ';
		}
		return recZaPrikaz.toCharArray();
	}

	/*
	 * @param slovo Metodi se prosledjuje slovo koje je igrac odabrao.
	 * 
	 * @param recZaPrikazNiz Metodi se prosledjuje rec koja se prikazuje, u
	 * obliku niza.
	 * 
	 * @return Metoda vraca izmenjenu rec za prikaz, u obliku niza.
	 * 
	 * Metoda proverava da li se na nekom mestu u nizu karaktera koji je
	 * prosledjen kao parametar nalazi slovo koje je takodje prosledjeno kao
	 * parameter. Ukoliko jeste, onda se vrednost elemenata na tim mestima u
	 * nizu menja na to slovo i na kraju metoda vraca izmenjenu rec za prikaz u
	 * obliku niza.
	 */
	public char[] dodajSlovo(char slovo, Boolean b) {
		String rec = trazenaRec.toUpperCase();
		if (getTrazenaRec().toUpperCase().indexOf(slovo) != -1){
			for (int i = 0; i < rec.length(); i++) {
				if (rec.charAt(i) == slovo) {
					recZaPrikazNiz[i] = slovo;
				}
			}
		}else {
			povecajBrojPromasaja();
			b = true;
		}
		return recZaPrikazNiz;

	}


	// Marina: Bio je ovde bag, recZaPrikazNiz kad se konvertuje
	// u String daje adresu, a ne taj string
//	if (String.copyValueOf(recZaPrikazNiz).toUpperCase().equals(igrica.getTrazenaRec().toUpperCase())) {
//		igrica.igracJePobedio();
//		btnOk.setVisible(false);
//		setVisible(false);
//		dispose();
//	}
//	}

	/*
	 * @param text metodi se prosledjuje tekst koji igrac unese.
	 * 
	 * @return Metoda vraca boolean vrednost koja oznacava da li je uneti tekst
	 * jednak trazenoj reci.
	 * 
	 * Metoda proverava, bez obaziranja na velika i mala slova, da li je uneti
	 * tekst jednak pojmu koji se trazi. Ako jeste, metoda vraca true, a u
	 * suprotnom vraca false.
	 */
	public boolean daLiJePogodioCeluRec() {
		if (recZaPrikazNiz.toString().equalsIgnoreCase(trazenaRec))
			return true;
		else {
			brojPromasaja++;
			return false;
		}
	}
	
	public boolean probajOdjednom(String text){
		if (text.toString().equalsIgnoreCase(trazenaRec))return true;
		else {
			povecajBrojPromasaja();
			return false;
		}
	}
	
	public boolean daLiJeIzgubio(){
		if (getBrojPromasaja() == 6) {
			return true;
		}
		return false;
	}

	/*
	 * Metoda povecava broj promasaja za 1.
	 */
	public void povecajBrojPromasaja() {
		brojPromasaja++;
	}
}
