package sistemskeoperacije;

import baza.Hangman;
import baza.Igraci;

public class SOInicijalizujIgraca {
	/*
	 * @param ime Ime igraca.
	 * 
	 * @param igraci Lista svih igraca.
	 * 
	 * @param indexTrenutnogIgraca Indeks igraca u listi igraca.
	 * 
	 * @return Metoda vraca boolean vrednost koja pokazuje da li je igrac vec
	 * igrao ili nije.
	 * 
	 * Ukoliko igrac sa imenom koji se prosledjuje kao parametar vec postoji u
	 * listi igraca, metoda vraca false i pronalazi njegov indeks u listi
	 * igraca. U suprotnom, metoda kreira novog igraca i ubacuje ga u listu.
	 * 
	 */
	public static boolean izvrsi(String ime, Igraci igraci) {
		if (!igraci.daLiPostoji(ime)) {
			igraci.dodajIgraca(ime);
			return true;
		}
		return  false;
	}

}
