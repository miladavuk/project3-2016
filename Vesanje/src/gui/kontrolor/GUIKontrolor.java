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

/**
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
	/**
	 * Lista u kojoj se nalaze igraci.
	 */
	public static Hangman hangman;

	
	/**
	 * Metoda inicijaluzuje atribut igraca i postavlja trenutni indeks igraca na
	 * -1. Takodje, metoda otvara novi pocetni prozor, gde igrac moze da unese
	 * svoje ime i da pocne sa igrom.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se ne pokrene PocetniProzor.
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

	/**
	 * 
	 * Metoda otvara glavni prozor i omogucava igracu da pocne sa pogadjanjem.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se ne prikaze GlavniProzor.
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

	/**
	 * Metoda otvara novi JDijalog Pobeda.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se ne prikaze Pobeda.
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

	/**
	 * Metoda otvara novi JDijalog Poraz.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se ne prikaze Poraz.
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

	/**
	 * Metoda otvara novi prozor u kom je prikazan score za svaku kategoriju za
	 * izabranog igraca. U slucaju da nije izabran igrac (indeks trenutnog
	 * igraca jedank je -1), otvara se prozor koji upozorava da nije izabran
	 * igrac.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se ne prikaze prozorZaScore.
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

	/**
	 * Metoda poziva prozor za instrukcije, u kojima je detaljno objasnjeno kako
	 * se igra igrica.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se ne prikaze prozor za instrukcije.
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

	/**
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

	/**
	 * Metoda vraca igraca koji trenutno igra.
	 * @return hangman.vratiIgraca();
	 */
	public static Igrac vratiTrenutnogIgraca() {
		return hangman.vratiIgraca();
	}

	/**
	 * U slucaju da je korisnik hteo da pocne sa novom igrom, a da prethodno
	 * nije odabrao igraca, ova metoda otvara prozor da ga upozori da treba da
	 * izabere/kreira igraca.
	 */
	public static void upozoriDaNijeIzabranIgrac() {
		JOptionPane.showMessageDialog(pocetniProzor.getContentPane(), "You haven't chosen a player!");
	}

	/**
	 * Metoda poziva metodu za inicijaliziranje igrice za datog igraca.
	 * @param ime  Ime igraca.
	 * @return hangman.incijalizujIgraca(ime)
	 */
	public static boolean incijalizujIgraca(String ime) {
		return hangman.incijalizujIgraca(ime);
	}

	public static void probajCeluRec() {
		if (hangman.daLiJeIgracIzgubio()) {
			igracJeIzgubio();
			return;
		}
		if (hangman.daLiJeIgracPogodioCeluRec()) {
			igracJePobedio();
		}
	}

	/**
	 * Ukoliko je igrac izgubio zatvara se prozor za igricu i otvara dijalog za
	 * poraz.
	 */
	private static void igracJeIzgubio() {
		hangman.vratiIgraca().igracJeIzgubio();
		glavniProzor.dispose();
		prikaziPoraz();
	}

	/**
	 * Ukoliko je igrac pobedio zatvara se prozor za igricu i otvara dijalog za
	 * pobedu.
	 */
	private static void igracJePobedio() {
		hangman.vratiIgraca().igracJePobedio();
		glavniProzor.dispose();
		prikaziPobedu();
	}

	/**
	 * Metoda zatvara glavni prozor ako igrac odustane od igrice.
	 */
	public static void odustani() {
		hangman.vratiIgraca().igracJeIzgubio();
		glavniProzor.dispose();
	}

	/**
	 * Metoda dodaje slovo koje je igrac odabrao.
	 * @param slovo Odabrano slovo.
	 * @return hangman.dodajSlovo(slovo);
	 */
	public static char[] ubaciSlovo(char slovo) {
		return hangman.dodajSlovo(slovo);
	}

	/**
	 * Ukoliko je igrac pogodio sve pojmove iz sve kategorije metoda izbacuje
	 * dijaloga da ga obavesti o tome. U suprotnom, otvara se prozor sa igricom.
	 * Ako pak igrac nije uneo svoje ime, metoda poziva metodu da ga upozori o
	 * tome.
	 */
	public static void zapocniIgru() {
		if (vratiTrenutnogIgraca() != null) {
			if (hangman.vratiKategorije().length == 0)
				prikaziPresaoIgricu();
			else
				prikaziGlavniProzor();
		} else
			upozoriDaNijeIzabranIgrac();
	}

	/**
	 * Metoda vraca rec za prikaz u obliku * i praznih mesta iz odabrane
	 * kategorije.
	 * @param kategorija Odabrana kategorija.
	 * @return hangman.pokreniPartiju(kategorija)
	 */
	public static char[] pokreniPartiju(String kategorija) {
		return hangman.pokreniPartiju(kategorija);
	}

	/**
	 * @return Metoda vraca broj promasaja igraca.
	 * @return hangman.vratiBrojPromasaja()
	 */
	public static int vratiBrojPromasaja() {
		return hangman.vratiBrojPromasaja();
	}

	/**
	 * Metoda vraca boolean koji oznacava da li je igrac pogodio celu
	 * rec odjednom.
	 * Ukoliko igrac pogodi celu rec, glavni prozor se zatvara i poziva se
	 * metoda za pobedu. U suprotnom se vraca false.
	 * @param text Cela rec.
	 * @return boolean
	 */
	public static boolean probajOdjednom(String text) {
		if (hangman.vratiIgraca().getIgrica().probajOdjednom(text)) {
			glavniProzor.dispose();
			igracJePobedio();
			return true;
		} else
			return false;
	}

}
