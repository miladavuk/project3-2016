package baza;

import java.io.Serializable;
import java.util.LinkedList;

public class Igrac implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime;
	private LinkedList<Integer> knjige;
	private LinkedList<Integer> drzave;
	private LinkedList<Integer> filmovi;
	private LinkedList<Integer> brendovi;
	private LinkedList<Integer> poznateLicnosti;
	private LinkedList<Integer> istorijskeLicnosti;
	
	public Igrac(String ime) {
		this.ime = ime;
		knjige = new LinkedList<>();
		drzave = new LinkedList<>();
		filmovi = new LinkedList<>();
		brendovi = new LinkedList<>();
		poznateLicnosti = new LinkedList<>();
		istorijskeLicnosti = new LinkedList<>();
	}
	
	public String getIme() {
		return ime;
	}

	public LinkedList<Integer> getKnjige() {
		return knjige;
	}

	public LinkedList<Integer> getDrzave() {
		return drzave;
	}

	public LinkedList<Integer> getFilmovi() {
		return filmovi;
	}

	public LinkedList<Integer> getBrendovi() {
		return brendovi;
	}

	public LinkedList<Integer> getPoznateLicnosti() {
		return poznateLicnosti;
	}

	public LinkedList<Integer> getIstorijskeLicnosti() {
		return istorijskeLicnosti;
	}
	
	public void ubaciKnjigu(int index){
		knjige.add(new Integer(index));
	}
	
	public void ubaciDrzavu(int index){
		drzave.add(new Integer(index));
	}
	
	public void ubaciFilm(int index){
		filmovi.add(new Integer(index));
	}
	
	public void ubaciBrend(int index){
		brendovi.add(new Integer(index));
	}
	
	public void ubaciIstorijskuLicnost(int index){
		istorijskeLicnosti.add(new Integer(index));
	}
	
	public void ubaciPoznatuLicnost(int index){
		poznateLicnosti.add(new Integer(index));
	}
}
