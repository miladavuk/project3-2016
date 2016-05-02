package baza;

import static org.junit.Assert.*;

import org.junit.Test;

public class KategorijeTest {

	@Test
	public void getKnjigeTestVelicina() {
		assertEquals(20, Kategorije.getKnjige().length);
	}

	@Test
	public void getKnjigeVratiTreci() {
		assertEquals("The kite runner", Kategorije.getKnjige()[2]);
	}

	@Test
	public void getDrzaveTestVelicina() {
		assertEquals(20, Kategorije.getDrzave().length);
	}

	@Test
	public void getDrzaveVratiTrecu() {
		assertEquals("Republic of Djibouti", Kategorije.getDrzave()[2]);
	}

	@Test
	public void getFilmoviTestVelicina() {
		assertEquals(20, Kategorije.getFilmovi().length);
	}

	@Test
	public void getFilmoviVratiTreci() {
		assertEquals("Despicable Me", Kategorije.getFilmovi()[2]);
	}

	@Test
	public void getBrendvoviTestVelicina() {
		assertEquals(20, Kategorije.getBrendovi().length);
	}

	@Test
	public void getBrendoviVratiTreci() {
		assertEquals("Bershka", Kategorije.getBrendovi()[2]);
	}

	@Test
	public void getPoznateLicnostiTestVelicina() {
		assertEquals(20, Kategorije.getPoznateLicnosti().length);
	}

	@Test
	public void getPoznateLicnostiVratiTrecu() {
		assertEquals("Brad Pitt", Kategorije.getPoznateLicnosti()[2]);
	}

	@Test
	public void getIstorijskeLicnostiTestVelicina() {
		assertEquals(20, Kategorije.getIstorijskeLicnosti().length);
	}

	@Test
	public void getIstorijskeLicnostiVratiTrecu() {
		assertEquals("George Washington", Kategorije.getIstorijskeLicnosti()[2]);
	}

}
