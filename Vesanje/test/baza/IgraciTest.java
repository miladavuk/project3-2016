package baza;

import static org.junit.Assert.*;

import org.junit.Test;

public class IgraciTest {

	@Test
	public void daLiPostojiTestPostoji() {
		Igraci igraci = new Igraci();
		igraci.dodajIgraca("Luka");
		assertTrue(igraci.daLiPostoji("Luka"));
	}
	
	@Test
	public void daLiPostojiTestNePostoji() {
		Igraci igraci = new Igraci();
		igraci.dodajIgraca("Beyonce");
		assertFalse(igraci.daLiPostoji("Luka"));
	}
	
	@Test
	public void dodajIgracaTest(){
		Igraci i = new Igraci();
		i.dodajIgraca("Luka");
		assertTrue(i.daLiPostoji("Luka"));
	}
	
	@Test
	public void vratiIndexIgracaTestPostoji(){
		Igraci i = new Igraci();
		i.dodajIgraca("Luka");
		i.dodajIgraca("Silvana");
		i.dodajIgraca("Nirvana");
		assertTrue(i.vratiIndexIgraca("Nirvana")==2);
	}
	
	@Test
	public void vratiIndexIgracaTestNePostoji(){
		Igraci i = new Igraci();
		i.dodajIgraca("Luka");
		i.dodajIgraca("Silvana");
		i.dodajIgraca("Nirvana");
		assertTrue(i.vratiIndexIgraca("Beyonce")==-1);
	}
	
	@Test
	public void vratiIgracaTest(){
		Igraci i = new Igraci();
		i.dodajIgraca("Luka");
		i.dodajIgraca("Silvana");
		i.dodajIgraca("Nirvana");
		assertTrue(i.vratiIgraca(2).getIme().equals("Nirvana"));
	}

}
