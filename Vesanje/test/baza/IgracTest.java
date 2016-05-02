package baza;

import static org.junit.Assert.*;

import org.junit.Test;

public class IgracTest {

	@Test
	public void ubaciKnjiguTest() {
		Igrac i = new Igrac("Bey");
		i.ubaciKnjigu(2);
		i.ubaciKnjigu(14);
		i.ubaciKnjigu(4);
		assertEquals(4, i.getKnjige().getLast().intValue());
	}

	@Test
	public void ubaciBrendTest() {
		Igrac i = new Igrac("Bey");
		i.ubaciBrend(8);
		i.ubaciBrend(12);
		i.ubaciBrend(4);
		assertEquals(4, i.getBrendovi().getLast().intValue());
	}

	@Test
	public void ubaciFilmTest() {
		Igrac i = new Igrac("Bey");
		i.ubaciFilm(3);
		i.ubaciFilm(8);
		i.ubaciFilm(4);
		assertEquals(4, i.getFilmovi().getLast().intValue());
	}

	@Test
	public void ubaciDrazvuTest() {
		Igrac i = new Igrac("Bey");
		i.ubaciDrzavu(8);
		i.ubaciDrzavu(12);
		i.ubaciDrzavu(4);
		assertEquals(4, i.getDrzave().getLast().intValue());
	}

	@Test
	public void ubaciPoznatuLicnostTest() {
		Igrac i = new Igrac("Bey");
		i.ubaciPoznatuLicnost(8);
		i.ubaciPoznatuLicnost(12);
		i.ubaciPoznatuLicnost(4);
		assertEquals(4, i.getPoznateLicnosti().getLast().intValue());
	}

	@Test
	public void ubaciIstorijskuLicnostTest() {
		Igrac i = new Igrac("Bey");
		i.ubaciIstorijskuLicnost(8);
		i.ubaciIstorijskuLicnost(12);
		i.ubaciIstorijskuLicnost(4);
		assertEquals(4, i.getIstorijskeLicnosti().getLast().intValue());
	}

	@Test
	public void igracJeIzgubioTest() {
		Igrac i = new Igrac("Bey");
		i.igracJeIzgubio();
		assertTrue(i.getIgrica() == null);
	}


}
