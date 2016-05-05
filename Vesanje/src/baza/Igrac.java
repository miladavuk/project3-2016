package baza;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

/**
 * 		Klasa sadrzi osnovne informacije o igracu. 
 * 		Svi podaci o igracima se serijalizuju.
 * 		Sadrzi informacije o tome koje pojmove iz odredjene kategorije je igrac uspeo da pogodi.
 */

public class Igrac implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Atribut oznacava ime igraca.
	 */
	private String ime;

	/**
	 * Ovi atributi predstavljaju listu indeksa pojmova iz nizova kategorija,
	 * koje je igrac uspeo da pogodi.
	 */
	private LinkedList<Integer> knjige;
	private LinkedList<Integer> drzave;
	private LinkedList<Integer> filmovi;
	private LinkedList<Integer> brendovi;
	private LinkedList<Integer> poznateLicnosti;
	private LinkedList<Integer> istorijskeLicnosti;

	/**
	 * Atribut predstavlja igricu koja je inicijalizovana.
	 */
	private Igrica igrica;
	/**
	 * Atribut predstavlja indeks reci koja se pogadja.
	 */
	private int indexReci;
	/**
	 * Atribut predstavlja kategoriju pojma koji se pogadja.
	 */
	private String kategorija;

	/**
	 * Metoda vraca indeks reci koju igrac pogadja iz odredjene
	 * kategorije.
	 * @return indexReci
	 */
	public int getIndexReci() {
		return indexReci;
	}

	/**
	 * Metoda vraca igricu koja je trenutno pokrenuta.
	 * @return igrica
	 */

	public Igrica getIgrica() {
		return igrica;
	}

	/**
	 * @param kategorija Kategorija reci
	 * 
	 * @return igrica.vratiRecZaPrikaz().
	 * 
	 * Metoda vraca niz karaktera koji se sastoji od * na mestima na koja se
	 * nalaze slova.
	 */
	public char[] pokreniIgricu(String kategorija) {
		this.kategorija = kategorija;
		igrica = new Igrica(vratiRec(kategorija));
		return igrica.vratiRecZaPrikaz();

	}

	/**
	 * @param ime 
	 * Konstruktor postavlja vrednost polja ime na vrednost unetog
	 * atributa i inicijalizuje gore pomenute liste indeksa.
	 */
	public Igrac(String ime) {
		this.ime = ime;
		knjige = new LinkedList<>();
		drzave = new LinkedList<>();
		filmovi = new LinkedList<>();
		brendovi = new LinkedList<>();
		poznateLicnosti = new LinkedList<>();
		istorijskeLicnosti = new LinkedList<>();
	}

	/**
	 * @return ime
	 * Metoda vraca vrednost atributa ime.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @return knjige
	 * Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * knjige.
	 */
	public LinkedList<Integer> getKnjige() {
		return knjige;
	}

	/**
	 * @return drzave
	 * Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * drzave.
	 */
	public LinkedList<Integer> getDrzave() {
		return drzave;
	}

	/**
	 * @return filmovi
	 * Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * filmovi.
	 */
	public LinkedList<Integer> getFilmovi() {
		return filmovi;
	}

	/**
	 * @return brendovi
	 * Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * brendovi.
	 */
	public LinkedList<Integer> getBrendovi() {
		return brendovi;
	}

	/**
	 * @return poznateLicnosti
	 * Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * poznate licnosti.
	 */
	public LinkedList<Integer> getPoznateLicnosti() {
		return poznateLicnosti;
	}

	/**
	 * @return istorijskeLicnosti
	 * Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * istorijske licnosti.
	 */
	public LinkedList<Integer> getIstorijskeLicnosti() {
		return istorijskeLicnosti;
	}

	/**
	 * @param index 
	 * Indeks pogodjenog pojma iz kategorije knjige se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciKnjigu(int index) {
		knjige.add(new Integer(index));
	}

	/**
	 * @param index 
	 * Indeks pogodjenog pojma iz kategorije drzave se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciDrzavu(int index) {
		drzave.add(new Integer(index));
	}

	/**
	 * @param index 
	 * Indeks pogodjenog pojma iz kategorije filmovi se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciFilm(int index) {
		filmovi.add(new Integer(index));
	}

	/**
	 * @param index 
	 * Indeks pogodjenog pojma iz kategorije brendovi se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciBrend(int index) {
		brendovi.add(new Integer(index));
	}

	/**
	 * @param index 
	 * Indeks pogodjenog pojma iz kategorije istorijske licnosti se
	 * ubacuje u listu indeksa za tu kategoriju.
	 */
	public void ubaciIstorijskuLicnost(int index) {
		istorijskeLicnosti.add(new Integer(index));
	}

	/**
	 * @param index 
	 * Indeks pogodjenog pojma iz kategorije poznate licnosti se
	 * ubacuje u listu indeksa za tu kategoriju.
	 */
	public void ubaciPoznatuLicnost(int index) {
		poznateLicnosti.add(new Integer(index));
	}

	/**
	 * @param kategorija	 Kategorija reci
	 * @return reciIzKategorije[indexReci = vratiRandom(reci)]
	 * U zavistosti od izabrane kategorije pojmova, metoda vraca rec iz
	 * kategorije pozivanjem metode za odabir random reci. Uz pomoc liste reci
	 * se odredjuje indeks moguceg pojma za odabir iz odgovarajuce kategorije.U
	 * listi se nalaze indeksi pogodjenih pojmova.
	 */
	private String vratiRec(String kategorija) {
		LinkedList<Integer> reci = null;
		String[] reciIzKategorije = null;
		switch (kategorija.toLowerCase()) {
		case "movies":
			reci = getFilmovi();
			reciIzKategorije = Kategorije.getFilmovi();
			break;
		case "classical books":
			reci = getKnjige();
			reciIzKategorije = Kategorije.getKnjige();
			break;
		case "countries":
			reci = getDrzave();
			reciIzKategorije = Kategorije.getDrzave();
			break;
		case "historical people":
			reci = getIstorijskeLicnosti();
			reciIzKategorije = Kategorije.getIstorijskeLicnosti();
			break;
		case "famous people":
			reci = getPoznateLicnosti();
			reciIzKategorije = Kategorije.getPoznateLicnosti();
			break;
		case "famous brands":
			reci = getBrendovi();
			reciIzKategorije = Kategorije.getBrendovi();
			break;
		}
		return reciIzKategorije[indexReci = vratiRandom(reci)];
	}

	/**
	 * @param brojevi Lista brojeva
	 * @return randomBroj
	 * Metoda generise random broj i proverava da li se nalazi u listi brojeva.
	 * Ukoliko se nalazi, generise se naredni random broj, a u suprotnom se
	 * vraca kao povratna vrednost.
	 * 
	 */
	private int vratiRandom(LinkedList<Integer> brojevi) {
		Random r = new Random();
		int randomBroj;
		do {
			randomBroj = r.nextInt(20);
		} while (brojevi.contains(randomBroj));
		return randomBroj;
	}

	/**
	 * @return kat.toArray(new String[0])
	 * 
	 * Metoda proverava da li je igrac pogodio sve pojmove iz odregjene
	 * kategorije. Ukoliko nije, naziv pojma se dodaje u listu, koja se kasnije
	 * konvertuje u niz Stringova i vraca kao povratna vrednost.
	 * 
	 * 
	 */
	public String[] vratiKategorije() {
		LinkedList<String> kat = new LinkedList<>();
		if (getFilmovi().size() < 20)
			kat.add("Movies");
		if (getDrzave().size() < 20)
			kat.add("Countries");
		if (getKnjige().size() < 20)
			kat.add("Classical books");
		if (getIstorijskeLicnosti().size() < 20)
			kat.add("Historical people");
		if (getBrendovi().size() < 20)
			kat.add("Famous brands");
		if (getPoznateLicnosti().size() < 20)
			kat.add("Famous people");
		return kat.toArray(new String[0]);
	}

	/**
	 * Metoda postavlja vrednost inicijalizovane igrice na null, ako igrac ne
	 * uspe da pogodi pojam koji se trazi.
	 */
	public void igracJeIzgubio() {
		igrica = null;
	}

	/**
	 * U slucaju da je igrac pogodio pojam, on se dodaje u listu pojmova koje je
	 * igrac pogodio i gasi se inicijalizovana igrica.
	 */
	public void igracJePobedio() {
		switch (kategorija) {
		case "Movies":
			ubaciFilm(indexReci);
			break;
		case "Countries":
			ubaciDrzavu(indexReci);
			break;
		case "Classical books":
			ubaciKnjigu(indexReci);
			break;
		case "Historical people":
			ubaciIstorijskuLicnost(indexReci);
			break;
		case "Famous people":
			ubaciPoznatuLicnost(indexReci);
			break;
		case "Famous brands":
			ubaciBrend(indexReci);
			break;
		}
		igrica = null;
	}
}
