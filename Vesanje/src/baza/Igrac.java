package baza;

import java.io.Serializable;
import java.util.LinkedList;

/*
 * 		Klasa sadrzi osnovne informacije o igracu. 
 * 		Svi podaci o igracima se serijalizuju.
 * 		Sadrzi informacije o tome koje pojmove iz odredjene kategorije je igrac uspeo da pogodi.
 */

public class Igrac implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Atribut oznacava ime igraca.
	 */
	private String ime;

	/*
	 * Ovi atributi predstavljaju listu indeksa pojmova iz nizova kategorija,
	 * koje je igrac uspeo da pogodi.
	 */
	private LinkedList<Integer> knjige;
	private LinkedList<Integer> drzave;
	private LinkedList<Integer> filmovi;
	private LinkedList<Integer> brendovi;
	private LinkedList<Integer> poznateLicnosti;
	private LinkedList<Integer> istorijskeLicnosti;

	/*
	 * @param ime Konstruktor postavlja vrednost polja ime na vrednost unetog
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

	/*
	 * @return Metoda vraca vrednost atributa ime.
	 */
	public String getIme() {
		return ime;
	}

	/*
	 * @return Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * knjige.
	 */
	public LinkedList<Integer> getKnjige() {
		return knjige;
	}

	/*
	 * @return Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * drzave.
	 */
	public LinkedList<Integer> getDrzave() {
		return drzave;
	}

	/*
	 * @return Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * filmovi.
	 */
	public LinkedList<Integer> getFilmovi() {
		return filmovi;
	}

	/*
	 * @return Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * brendovi.
	 */
	public LinkedList<Integer> getBrendovi() {
		return brendovi;
	}

	/*
	 * @return Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * poznate licnosti.
	 */
	public LinkedList<Integer> getPoznateLicnosti() {
		return poznateLicnosti;
	}

	/*
	 * @return Metoda vraca listu indeksa pogodjenih pojmova za kategoriju
	 * istorijske licnosti.
	 */
	public LinkedList<Integer> getIstorijskeLicnosti() {
		return istorijskeLicnosti;
	}

	/*
	 * @param index Indeks pogodjenog pojma iz kategorije knjige se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciKnjigu(int index) {
		knjige.add(new Integer(index));
	}

	/*
	 * @param index Indeks pogodjenog pojma iz kategorije drzave se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciDrzavu(int index) {
		drzave.add(new Integer(index));
	}

	/*
	 * @param index Indeks pogodjenog pojma iz kategorije filmovi se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciFilm(int index) {
		filmovi.add(new Integer(index));
	}

	/*
	 * @param index Indeks pogodjenog pojma iz kategorije brendovi se ubacuje u
	 * listu indeksa za tu kategoriju.
	 */
	public void ubaciBrend(int index) {
		brendovi.add(new Integer(index));
	}

	/*
	 * @param index Indeks pogodjenog pojma iz kategorije istorijske licnosti se
	 * ubacuje u listu indeksa za tu kategoriju.
	 */
	public void ubaciIstorijskuLicnost(int index) {
		istorijskeLicnosti.add(new Integer(index));
	}

	/*
	 * @param index Indeks pogodjenog pojma iz kategorije poznate licnosti se
	 * ubacuje u listu indeksa za tu kategoriju.
	 */
	public void ubaciPoznatuLicnost(int index) {
		poznateLicnosti.add(new Integer(index));
	}
}
