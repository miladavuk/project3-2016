package sistemskeoperacije;

import baza.Igraci;

public class SOSacuvajIgrace {
	/*
	 * Metoda poziva metodu za serijalizaciju igraca.
	 */
	public static void izvrsi(Igraci igraci) {
		igraci.serijalizujIgrace();
	}

}
