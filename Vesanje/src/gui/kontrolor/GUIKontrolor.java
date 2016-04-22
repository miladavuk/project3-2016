package gui.kontrolor;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JDialog;

import baza.Igrac;
import baza.Kategorije;
import gui.GlavniProzor;
import gui.Pobeda;
import gui.PocetniProzor;
import gui.Poraz;
import gui.Score;

public class GUIKontrolor {
	
	public static String trazenaRec="";
	public static int brojPromasaja=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetniProzor frame = new PocetniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziGlavniProzor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziPobedu() {
		try {
			Pobeda dialog = new Pobeda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void prikaziPoraz() {
		try {
			Poraz dialog = new Poraz();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String vratiString(String kategorija) {
		Kategorije k = new Kategorije();
		Random r = new Random();
		int randomBroj = r.nextInt(20);
		String recZaPrikaz = "";
		
		if(kategorija.equalsIgnoreCase("movies")){
			trazenaRec = k.getFilmovi()[randomBroj];
		}
		if(kategorija.equalsIgnoreCase("classical books")){
			trazenaRec = k.getKnjige()[randomBroj];
		}
		if(kategorija.equalsIgnoreCase("countries")){
			trazenaRec = k.getDrzave()[randomBroj];
		}
		if(kategorija.equalsIgnoreCase("hystoric people")){
			trazenaRec = k.getIstorijskeLicnosti()[randomBroj];
		}
		if(kategorija.equalsIgnoreCase("famous people")){
			trazenaRec = k.getPoznateLicnosti()[randomBroj];
		}
		if(kategorija.equalsIgnoreCase("famous brands")){
			trazenaRec = k.getBrendovi()[randomBroj];
		}
		for(int i=0; i<trazenaRec.length();i++){
			if(trazenaRec.charAt(i)!=' ')
				recZaPrikaz+='*';
			else
				recZaPrikaz+=' ';
		}
		return recZaPrikaz;
	}
	
	public static void prozorZaScore(final Igrac igrac){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
					frame.setIgrac(igrac);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
