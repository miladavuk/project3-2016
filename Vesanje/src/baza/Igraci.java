package baza;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * U ovoj klasi su implementirane osnovne metode za serijalizaciju i deserijalizaciju podataka o igracima.
 * Pored toga, ova klasa sluzi i za pretrazivanje i pronalazenje trazenog igraca.
 */

public class Igraci implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Lista koja sadrzi igrace.
	 */
	private LinkedList<Igrac> igraci;

	/**
	 * Konstruktor inicijalizuje listu igraca i deserijalizuje sve prethodno
	 * serijalizovane podatke o igracima.
	 */
	public Igraci() {
		igraci = new LinkedList<>();
		deserijalizujIgrace();
	}

	/**
	 * @param ime
	 * 
	 * Metoda proverava da li u listi igraca postoji igrac kod kog je
	 * vrednost atributa ime jednak vrednosti koja pokusava da se unese kao
	 * parametear. Ako jeste, metoda vraca true, a u suprotnom, vraca false.
	 * @return boolean
	 */
	public boolean daLiPostoji(String ime) {
		for (Igrac igrac : igraci) {
			if (igrac.getIme().equals(ime))
				return true;
		}
		return false;
	}
	/**
	 * Metoda dodaje novog igraca u listu cije se ime unosi kao parametar.
	 * @param ime Ime igraca
	 */

	public void dodajIgraca(String ime) {
		igraci.add(new Igrac(ime));
	}

	/**
	 * Metoda serijalizuje podatke o svim igracima iz liste igraca.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se igrac ne serijalizuje.
	 */
	public void serijalizujIgrace() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Igraci.ser"))) {
			out.writeObject(igraci);
		} catch (Exception e) {
		}

	}

	/**
	 * Metoda deserijalizuje sve podatke o igracima iz liste.
	 * 
	 * @throws Exception Metoda baca izuzetak ako se igraci ne deserijalizuju.
	 */
	@SuppressWarnings("unchecked")
	public void deserijalizujIgrace() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Igraci.ser"))) {
			igraci.addAll((LinkedList<Igrac>) in.readObject());
		} catch (Exception e) {
			System.out.println("Nije uspelo ocitavanje!");
		}
	}

	/**
	 * @param ime 
	 
	 * U slucaju da igrac sa prosledjenim imenom ne postoji u listi, metoda vraca
	 * vrednost -1, sto oznacava da nije unet jos u listu, u suprotnom vraca taj indeks.
	 * @return i Indeks igraca.
	 */
	public int vratiIndexIgraca(String ime) {
		for (int i = 0; i < igraci.size(); i++) {
			if (igraci.get(i).getIme().equals(ime))
				return i;
		}
		return -1;
	}

	/**
	 * @param index Indeks igraca.
	 * @return igraci.get(index)
	 * Metoda vraca igraca iz liste kojem pripada taj indeks.
	 */
	public Igrac vratiIgraca(int index) {
		if (index < 0 || index > igraci.size())
			return null;
		else
			return igraci.get(index);
	}

	/**
	 * Metoda ispisuje sva imena igraca iz liste.
	 */
	public void ispisiIgrace() {
		for (Igrac igrac : igraci) {
			System.out.println(igrac.getIme());
		}
	}
}
