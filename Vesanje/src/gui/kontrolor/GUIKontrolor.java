package gui.kontrolor;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import baza.Igrac;
import baza.Igraci;
import baza.Kategorije;
import gui.GlavniProzor;
import gui.Intructions;
import gui.Pobeda;
import gui.PocetniProzor;
import gui.Poraz;
import gui.Score;

/*
 *  Klasa sadrzi osnovne atribute i metode neophodne za 
 *  otvaranje svih prozora u okviru igrice. Pomocu ove
 *  klase se kontorlise otvaranje i zavarenje kako svih 
 *  prozora, tako i same aplikacije. Pored toga, sadrzi 
 *  osnovne atributi koji su neophodni za pronalazenje 
 *  trazenog pojma i cuvanje pdoataka o igracu i njegovom ucinku.
 */
public class GUIKontrolor {
	/*
	 * Atribut predstavlja rec za kojom igrac trazi.
	 */
	public static String trazenaRec = "";
	/*
	 * Atribut pokazuje koliko puta je igrac promasio u odabiru slova ili
	 * pokusaju pogadjanja cele reci. Pocetna vrednost je 0.
	 */
	public static int brojPromasaja = 0;
	/*
	 * Lista u kojoj se cuvaju slova koje je igrac iskoristio vec.
	 */
	public static LinkedList<Character> koriscenaSlova = new LinkedList<>();
	/*
	 * Atribut koji predstavlja broj slova koji je igrac iskoristio.
	 */
	public static int brojKoriscenihSlova = 0;
	/*
	 * Atribut koji predstavlja pocetni prozor igrice.
	 */
	public static PocetniProzor pocetniProzor;
	/*
	 * Lista u kojoj se nalaze igraci.
	 */
	public static Igraci igraci;
	/*
	 * Atribut koji predstavlja indeks igraca koji trenutno pogadja.
	 */
	public static int indexTrenutnogIgraca;

	/*
	 * Metoda inicijaluzuje atribut igraca i postavlja trenutni indeks igraca na
	 * -1. Takodje, metoda otvara novi pocetni prozor, gde igrac moze da unese
	 * svoje ime i da pocne sa igrom.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju da se ne otvori pocetni
	 * prozor.
	 */
	public static void main(String[] args) {
		igraci = new Igraci();
		indexTrenutnogIgraca = -1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pocetniProzor = new PocetniProzor();
					pocetniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * 
	 * Metoda otvara glavni prozor i omogucava igracu da pocne sa pogadjanjem.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju da se glavni prozor ne
	 * prikaze.\
	 */
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

	/*
	 * Metoda otvara novi JDijalog Pobeda.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju da se Pobeda ne otvori.
	 */
	public static void prikaziPobedu() {
		try {
			Pobeda dialog = new Pobeda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Metoda otvara novi JDijalog Poraz.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju da se Poraz ne otvori.
	 */
	public static void prikaziPoraz() {
		try {
			Poraz dialog = new Poraz();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Metoda otvara novi prozor u kom je prikazan score za svaku kategoriju za
	 * izabranog igraca. U slucaju da nije izabran igrac (indeks trenutnog
	 * igraca jedank je -1), otvara se prozor koji upozorava da nije izabran
	 * igrac.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se prozor za Score ne otvori.
	 */
	public static void prozorZaScore() {
		if (indexTrenutnogIgraca == -1) {
			upozoriDaNijeIzabranIgrac();
			return;
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Metoda poziva prozor za instrukcije, u kojima je detaljno objasnjeno kako
	 * se igra igrica.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju da se prozor za
	 * instrukcije ne otvori.
	 */
	public static void pozoviInstrukcije() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intructions frame = new Intructions();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Metoda gasi aplikaciju tako sto se otvori prozor koji pita da li je igrac
	 * siguran da zeli da napusti igricu. Ako jeste, onda se aplikacija gasi i
	 * svi podaci o igracima se serijalizuju, a u suprotnom se vraca na pocetni
	 * prozor.
	 * 
	 */
	public static void ugasiAplikaciju() {
		// Milada:promenjeno na engleski jer pravimo aplikaciju na engleskom! :)
		// Marina: Yeah, I forgot. xD
		int opcija = JOptionPane.showConfirmDialog(pocetniProzor.getContentPane(), "Are you sure you want to exit?",
				"Exit", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.NO_OPTION)
			return;
		if (opcija == JOptionPane.YES_OPTION) {
			igraci.serijalizujIgrace();
			System.exit(0);
		}
		// By Luka:
		// if(opcija==JOptionPane.NO_OPTION){
		// igraci.serijalizujIgrace();
		// sad ne znam kako se gasi ovaj optionPane, mislio sam da se ugasi, a
		// ne da se otvara novi glavni prozor :D
		// }

	}

	/*
	 * @return Metoda vraca igraca koji trenutno igra.
	 */
	public static Igrac vratiTrenutnogIgraca() {
		return igraci.vratiIgraca(indexTrenutnogIgraca);
	}

	/*
	 * U slucaju da je korisnik hteo da pocne sa novom igrom, a da prethodno
	 * nije odabrao igraca, ova metoda otvara prozor da ga upozori da treba da
	 * izabere/kreira igraca.
	 */
	public static void upozoriDaNijeIzabranIgrac() {
		JOptionPane.showMessageDialog(pocetniProzor.getContentPane(), "You haven't chosen a player!");
	}

	/*
	 * @param ime Metodi se prosledjuje ime igraca.
	 * 
	 * @return Metoda vraca boolean vrednost koja pokazuje da li je igrac vec
	 * ranije igrao ili nije. Ukoliko nije, metoda vraca true, a u suprotnom
	 * vraca false.
	 * 
	 * Metoda proverava da li se u listi igraca postoji igrac sa imenom koji je
	 * unet kao parametar. Ako ne postoji, metoda kreira novog igraca u listi sa
	 * tim imenom i postavlja indeks trenutnog igraca ne njegov indeks. Ako
	 * igrac vec postoji u listi, nalazi se njegov indeks i indeks trenutnog
	 * igraca se postavlja na tu vrednodt
	 */
	public static boolean incijalizujIgraca(String ime) {
		if (!igraci.daLiPostoji(ime)) {
			igraci.dodajIgraca(ime);
			indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
			return true;
		}
		indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
		return false;
	}

}
