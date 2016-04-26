package gui.kontrolor;

import java.util.LinkedList;
import java.util.Random;

import baza.Igrac;
import baza.Kategorije;

public class Igrica {
	private String trazenaRec;
	private int brojPromasaja;
	private LinkedList<Character> koriscenaSlova;
	private int brojKoriscenihSlova;
	private String kategorija;
	private int indexReci;
	private Igrac igrac;
	
	public Igrica(Igrac igrac){
		trazenaRec = "";
		this.igrac = igrac;
		brojPromasaja = 0;
//		koriscenaSlova = new LinkedList<>();
//		brojKoriscenihSlova = 0;
	}

	public String getTrazenaRec() {
		return trazenaRec;
	}


	public int getBrojPromasaja() {
		return brojPromasaja;
	}

//	public LinkedList<Character> getKoriscenaSlova() {
//		return koriscenaSlova;
//	}

//	public int getBrojKoriscenihSlova() {
//		return brojKoriscenihSlova;
//	}

	public String getKategorija() {
		return kategorija;
	}

	public int getIndexReci() {
		return indexReci;
	}

	public Igrac getIgrac() {
		return igrac;
	}
	
	public String vratiString(String kategorija) {
		Kategorije k = new Kategorije();
		this.kategorija = kategorija;
		Random r = new Random();
		int randomBroj = r.nextInt(20);
		String recZaPrikaz = "";

		if (kategorija.equalsIgnoreCase("movies")) {
			if(igrac.getFilmovi().size() >= 20) return "greska";
			if(igrac.getFilmovi().contains(randomBroj)) trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getFilmovi()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("classical books")) {
			if(igrac.getKnjige().size() >= 20) return "greska";
			if(igrac.getKnjige().contains(randomBroj)) trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getKnjige()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("countries")) {
			if(igrac.getDrzave().size() >= 20) return "greska";
			if(igrac.getDrzave().contains(randomBroj)) trazenaRec = vratiString(kategorija);
			else {
				trazenaRec = k.getDrzave()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("historic people")) {
			if(igrac.getIstorijskeLicnosti().size() >= 20) return "greska";
			if(igrac.getIstorijskeLicnosti().contains(randomBroj)) trazenaRec = vratiString(kategorija);
			else{
				trazenaRec = k.getIstorijskeLicnosti()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("famous people")) {
			if(igrac.getPoznateLicnosti().size() >= 20) return "greska";
			if(igrac.getPoznateLicnosti().contains(randomBroj)) trazenaRec = vratiString(kategorija);
			else{
				trazenaRec = k.getPoznateLicnosti()[randomBroj];
				indexReci = randomBroj;
			}
		}
		if (kategorija.equalsIgnoreCase("famous brands")) {
			if(igrac.getBrendovi().size() >= 20) return "greska";
			if(igrac.getBrendovi().contains(randomBroj)) trazenaRec = vratiString(kategorija);
			else{
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

	public char[] dodajSlovo(char slovo, char[] recZaPrikazNiz) {	
		//Marina: Ovde je bio bag, uporedjivali smo mala sa velikim slovima i nosmo dobijali dobar rezultat
		String rec = trazenaRec.toUpperCase();
		/*Milada: koristi se globalna promenljiva! ne ubacuju se '*' (one su vec tu)
		 * zato sto bi se pri svakom odabiru slova prikazalo samo to slovo i zvezdice*/
		
		for(int i = 0; i< rec.length();i++){
			if(rec.charAt(i) == slovo){
				recZaPrikazNiz[i]=slovo;
			}
		}
//		if(!koriscenaSlova.contains(slovo))
	//		koriscenaSlova.add(slovo);
			//Marina: Iskomentarisala sam podatke o koriscenim slovima jer nam nisu potrebni, jer sam sttavila da koriscena
		//slova izbacuje iz comboBoxa
		return recZaPrikazNiz;
		
	}
	
	public boolean probajCeluRec(String text) {	
		if(text.equalsIgnoreCase(trazenaRec))return true;
		else {
			brojPromasaja++;
			return false;
		}
	}
	
	public void igracJeIzgubio(){
		GUIKontrolor.prikaziPoraz();
	}
	
	public void igracJePobedio(){
		switch(kategorija){
			case "Movies":
				igrac.ubaciFilm(indexReci);
				break;
			case "Countries": 
				igrac.ubaciDrzavu(indexReci);
				break;
			case "Classical books":
				igrac.ubaciKnjigu(indexReci);
				break;
			case "Hystoric people":
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
	
	public void povecajBrojPromasaja(){
		brojPromasaja ++;
	}
}
