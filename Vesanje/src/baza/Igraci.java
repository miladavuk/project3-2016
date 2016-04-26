package baza;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/*
 * U ovoj klasi su implementirane osnovne metode za serijalizaciju i deserijalizaciju podataka o igracima.
 * Pored toga, ova klasa sluzi i za pretrazivanje i pronalazenje trazenog igraca.
 */

public class Igraci implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Lista koja sadrzi igrace.
	 */
	private LinkedList<Igrac> igraci;

	/*
	 * Konstruktor inicijalizuje listu igraca i deserijalizuje sve prethodno
	 * serijalizovane podatke o igracima.
	 */
	public Igraci() {
		igraci = new LinkedList<>();
		deserijalizujIgrace();
	}

	/*
	 * @param ime Predstavlja ime igraca.
	 * 
	 * @return Metoda proverava da li u listi igraca postoji igrac kod kog je
	 * vrednost atributa ime jednak vrednosti koja pokusava da se unese kao
	 * parametear. Ako jeste, metoda vraca true, a u suprotnom, vraca false.
	 */
	public boolean daLiPostoji(String ime) {
		for (Igrac igrac : igraci) {
			if (igrac.getIme().equals(ime))
				return true;
		}
		return false;
	}
	/*
	 * Metoda dodaje novog igraca u listu cije se ime unosi kao parametar.
	 */

	public void dodajIgraca(String ime) {
		igraci.add(new Igrac(ime));
	}

	/*
	 * Metoda serijalizuje podatke o svim igracima iz liste igraca.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju neuspesnog pokusaja
	 * serijlizacije podataka o igracima.
	 */
	public void serijalizujIgrace() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Igraci.ser"))) {
			out.writeObject(igraci);
		} catch (Exception e) {
			System.out.println("Nije uspelo serijalizovanje!");
		}

	}

	/*
	 * Metoda deserijalizuje sve podatke o igracima iz liste.
	 * 
	 * @throws Exception Metoda baca izuzetak u slucaju neuspesnog pokusaja
	 * deserijalizacije podataka o igracima.
	 */
	public void deserijalizujIgrace() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Igraci.ser"))) {
			igraci.addAll((LinkedList<Igrac>) in.readObject());
		} catch (Exception e) {
			System.out.println("Nije uspelo ocitavanje!");
		}
	}

	/*
	 * @param ime Metodi se prosledjuje ime igraca za kojim se traga.
	 * 
	 * @return Vraca se vrednost indeksa igraca u listi igraca.
	 * 
	 * U slucaju da igrac sa tim imenom ne postoji u listi, metoda vraca
	 * vrednost -1, sto oznacava da nije unet jos u listu.
	 */
	public int vratiIndexIgraca(String ime) {
		for (int i = 0; i < igraci.size(); i++) {
			if (igraci.get(i).getIme().equals(ime))
				return i;
		}
		return -1;
	}

	/*
	 * @param index Metodi se prosledjuje indeks igraca za kojim se traga.
	 * 
	 * @return Metoda vraca igraca iz liste kojem pripada taj indeks.
	 */
	public Igrac vratiIgraca(int index) {
		return igraci.get(index);
	}

	/*
	 * Metoda ispisuje sva imena igraca iz liste.
	 */
	public void ispisiIgrace() {
		for (Igrac igrac : igraci) {
			System.out.println(igrac.getIme());
		}
	}
}
