package gui.kontrolor;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import baza.Hangman;
import baza.Igrac;
import gui.GlavniProzor;
import gui.Intructions;
import gui.Pobeda;
import gui.PocetniProzor;
import gui.Poraz;
import gui.PresaoIgricu;
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
	public static GlavniProzor glavniProzor;
	public static PocetniProzor pocetniProzor;
	/*
	 * Lista u kojoj se nalaze igraci.
	 */
	public static Hangman hangman;

	/*
	 * Metoda inicijaluzuje atribut igraca i postavlja trenutni indeks igraca na
	 * -1. Takodje, metoda otvara novi pocetni prozor, gde igrac moze da unese
	 * svoje ime i da pocne sa igrom.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju da se ne otvori pocetni
	 * prozor.
	 */
	public static void main(String[] args) {
		hangman = new Hangman();
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
					glavniProzor = new GlavniProzor(hangman.vratiKategorije());
					glavniProzor.setVisible(true);
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
		if (hangman.vratiIgraca() == null) {
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
			hangman.sacuvajIgrace();
			System.exit(0);
		}
		// By Luka:
		// if(opcija==JOptionPane.NO_OPTION){
		// igraci.serijalizujIgrace();
		// sad ne znam kako se gasi ovaj optionPane, mislio sam da se ugasi, a
		// ne da se otvara novi glavni prozor :D
		// }

	}

	
	public static void prikaziPresaoIgricu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresaoIgricu frame = new PresaoIgricu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 * @return Metoda vraca igraca koji trenutno igra.
	 */
	public static Igrac vratiTrenutnogIgraca() {
		return hangman.vratiIgraca();
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
		return hangman.incijalizujIgraca(ime);
	}

	public static void probajCeluRec() {
		if(hangman.daLiJeIgracIzgubio()){
			igracJeIzgubio();
		}
		if(hangman.daLiJeIgracPogodioCeluRec()){
			igracJePobedio();
		}
	}

	private static void igracJeIzgubio() {
		hangman.vratiIgraca().igracJeIzgubio();
		glavniProzor.dispose();
		prikaziPoraz();
	}

	private static void igracJePobedio() {
		hangman.vratiIgraca().igracJePobedio();
		glavniProzor.dispose();
		prikaziPobedu();
	}

	public static void odustani() {
		hangman.vratiIgraca().igracJeIzgubio();
		glavniProzor.dispose();
	}

	public static char[] ubaciSlovo(char slovo) {
		return hangman.dodajSlovo(slovo);
	}

	public static void zapocniIgru() {
		if(vratiTrenutnogIgraca() != null) {
			if(hangman.vratiKategorije().length == 0) prikaziPresaoIgricu();
			else prikaziGlavniProzor();
		}
		else upozoriDaNijeIzabranIgrac();
	}

	public static char[] pokreniPartiju(String kategorija) {
		return hangman.pokreniPartiju(kategorija);
	}

	public static int vratiBrojPromasaja() {
		return hangman.vratiBrojPromasaja();
	}
	
	public static boolean probajOdjednom(String text){
		if(hangman.vratiIgraca().getIgrica().probajOdjednom(text)){
			glavniProzor.dispose();
			igracJePobedio();
			return true;
		}else return false;
	}
	
	
}
