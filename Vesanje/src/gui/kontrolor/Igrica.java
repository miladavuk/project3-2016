package gui.kontrolor;

import java.util.LinkedList;
import java.util.Random;

import baza.Igrac;
import baza.Kategorije;

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
	 * Lista u kojoj se cuvaju slova koje je igrac iskoristio vec.
	 */
	private LinkedList<Character> koriscenaSlova;
	/*
	 * Atribut koji predstavlja broj slova koji je igrac iskoristio.
	 */
	private int brojKoriscenihSlova;
	/*
	 * Atribut predstavlja kategoriju za koju se odlucio igrac.
	 */
	private String kategorija;
	/*
	 * Atribut predstavlja indeks reci u nizu kategorije kojoj pripada.
	 */
	private int indexReci;
	/*
	 * Atribut predstavlja igraca.
	 */
	private Igrac igrac;

	/*
	 * @param igrac Metodi se prosledjuje igrac koji trenutno igra.
	 * 
	 * Konstruktor postavlja vrednosti gore pomenutih atributa na odredjene
	 * vrednosti. trazenaRec postaje prazan String, igrac se postavlja na
	 * vrednost unetu kao parametar, a broj promasaja na 0, cime je
	 * inicijalizovana igrica.
	 */
	public Igrica(Igrac igrac) {
		trazenaRec = "";
		this.igrac = igrac;
		brojPromasaja = 0;
		// koriscenaSlova = new LinkedList<>();
		// brojKoriscenihSlova = 0;
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
	 * @return Metoda vraca kategoriju za koju se odlucio igrac.
	 */
	public String getKategorija() {
		return kategorija;
	}

	/*
	 * @return Metoda vraca indeks reci koja se pogadja.
	 */
	public int getIndexReci() {
		return indexReci;
	}

	/*
	 * @return Metoda vraca igraca koji pogadja.
	 */
	public Igrac getIgrac() {
		return igrac;
	}

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
	public String vratiString(String kategorija) {
		Kategorije k = new Kategorije();
		this.kategorija = kategorija;
		Random r = new Random();
		int randomBroj = r.nextInt(20);
		String recZaPrikaz = "";

		if (kategorija.equalsIgnoreCase("movies")) {
			if (igrac.getFilmovi().size() >= 20)
				return "greska";
			if (igrac.getFilmovi().contains(randomBroj))
				trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getFilmovi()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("classical books")) {
			if (igrac.getKnjige().size() >= 20)
				return "greska";
			if (igrac.getKnjige().contains(randomBroj))
				trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getKnjige()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("countries")) {
			if (igrac.getDrzave().size() >= 20)
				return "greska";
			if (igrac.getDrzave().contains(randomBroj))
				trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getDrzave()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("historical people")) {
			if (igrac.getIstorijskeLicnosti().size() >= 20)
				return "greska";
			if (igrac.getIstorijskeLicnosti().contains(randomBroj))
				trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getIstorijskeLicnosti()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("famous people")) {
			if (igrac.getPoznateLicnosti().size() >= 20)
				return "greska";
			if (igrac.getPoznateLicnosti().contains(randomBroj))
				trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getPoznateLicnosti()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("famous brands")) {
			if (igrac.getBrendovi().size() >= 20)
				return "greska";
			if (igrac.getBrendovi().contains(randomBroj))
				trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getBrendovi()[randomBroj];
				indexReci = randomBroj;
			}
		}
		for (int i = 0; i < trazenaRec.length(); i++) {
			if (trazenaRec.charAt(i) != ' ')
				recZaPrikaz += '*';
			else
				recZaPrikaz += ' ';
		}
		return recZaPrikaz;
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
	public char[] dodajSlovo(char slovo, char[] recZaPrikazNiz) {
		// Marina: Ovde je bio bag, uporedjivali smo mala sa velikim slovima i
		// nosmo dobijali dobar rezultat
		String rec = trazenaRec.toUpperCase();
		/*
		 * Milada: koristi se globalna promenljiva! ne ubacuju se '*' (one su
		 * vec tu) zato sto bi se pri svakom odabiru slova prikazalo samo to
		 * slovo i zvezdice
		 */

		for (int i = 0; i < rec.length(); i++) {
			if (rec.charAt(i) == slovo) {
				recZaPrikazNiz[i] = slovo;
			}
		}
		// if(!koriscenaSlova.contains(slovo))
		// koriscenaSlova.add(slovo);
		// Marina: Iskomentarisala sam podatke o koriscenim slovima jer nam nisu
		// potrebni, jer sam sttavila da koriscena
		// slova izbacuje iz comboBoxa
		return recZaPrikazNiz;

	}

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
	public boolean probajCeluRec(String text) {
		if (text.equalsIgnoreCase(trazenaRec))
			return true;
		else {
			brojPromasaja++;
			return false;
		}
	}

	/*
	 * Metoda poziva metodu za prikaz JDialoga Poraz.
	 */
	public void igracJeIzgubio() {
		GUIKontrolor.prikaziPoraz();
	}

	/*
	 * U slucaju da je igrac pogodio pojam, on se dodaje u listu pojmova koje je
	 * igrac pogodio. Potom se otvara JDialog Pobeda.
	 */
	public void igracJePobedio() {
		switch (kategorija) {
		case "Movies":
			igrac.ubaciFilm(indexReci);
			break;
		case "Countries":
			igrac.ubaciDrzavu(indexReci);
			break;
		case "Classical books":
			igrac.ubaciKnjigu(indexReci);
			break;
		case "Historical people":
			igrac.ubaciIstorijskuLicnost(indexReci);
			break;
		case "Famous people":
			igrac.ubaciPoznatuLicnost(indexReci);
			break;
		case "Famous brands":
			igrac.ubaciBrend(indexReci);
			break;
		}
		GUIKontrolor.prikaziPobedu();
	}

	/*
	 * Metoda povecava broj promasaja za 1.
	 */
	public void povecajBrojPromasaja() {
		brojPromasaja++;
	}
}
