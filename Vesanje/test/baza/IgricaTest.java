package baza;

import static org.junit.Assert.*;

import org.junit.Test;

public class IgricaTest {

	@Test
	public void getTrazenaRecPriInicijalizacijiTest() {
		Igrica i = new Igrica("Beyonce");
		assertEquals("Beyonce", i.getTrazenaRec());
	}

	@Test
	public void getBrojPromasajaPriInicjalizacijiTest() {
		Igrica i = new Igrica("Beyonce");
		assertEquals(0, i.getBrojPromasaja());
	}

	@Test
	public void vratiRecZaPrikazPriInicijalizacijiPrviTest() {
		Igrica i = new Igrica("Beyonce");
		assertEquals(i.getTrazenaRec().length(), i.vratiRecZaPrikaz().length);
	}

	@Test
	public void vratiRecZaPrikazPriInicijalizacijiDrugiTest() {
		Igrica i = new Igrica("Beyonce");
		assertTrue(!(i.getTrazenaRec().charAt(3) == i.vratiRecZaPrikaz()[3]));
	}

	@Test
	public void probajOdjednomTestTrue() {
		Igrica i = new Igrica("Beyonce");
		assertTrue(i.probajOdjednom("Beyonce"));
	}

	@Test
	public void probajOdjednomTestFalse() {
		Igrica i = new Igrica("Beyonce");
		assertFalse(i.probajOdjednom("Stoja"));
	}

	@Test
	public void daLiJeIzgubioTest() {
		Igrica i = new Igrica("Beyonce");
		i.dodajSlovo('q');
		i.dodajSlovo('w');
		i.dodajSlovo('r');
		i.dodajSlovo('t');
		i.dodajSlovo('u');
		i.dodajSlovo('i');
		assertTrue(i.daLiJeIzgubio());
	}

	@Test
	public void povecajBrojPromasajaTest() {
		Igrica i = new Igrica("Beyonce");
		i.povecajBrojPromasaja();
		assertTrue(i.getBrojPromasaja() == 1);
	}

	@Test
	public void dodajSlovoTestPravoSlovo() {
		Igrica i = new Igrica("Beyonce");
		assertTrue(i.dodajSlovo('B')[0] == 'B');
	}

	@Test
	public void dodajSlovoTestPogresnoSlovo() {
		Igrica i = new Igrica("Beyonce");
		assertTrue(i.dodajSlovo('R').toString().indexOf("R") == -1);
	}

	@Test
	public void daLiJePogodioCeluRecTestNije() {
		Igrica i = new Igrica("Beyonce");
		i.dodajSlovo('B');
		assertFalse(i.daLiJePogodioCeluRec());
	}
	
	@Test
	public void daLiJePogodioCeluRecTestJest() {
		Igrica i = new Igrica("Beyonce");
		i.dodajSlovo('B');
		i.dodajSlovo('E');
		i.dodajSlovo('Y');
		i.dodajSlovo('O');
		i.dodajSlovo('N');
		i.dodajSlovo('C');
		assertTrue(i.daLiJePogodioCeluRec());
	}
}
