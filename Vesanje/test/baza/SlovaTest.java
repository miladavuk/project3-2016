package baza;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlovaTest {

	// iz nekog razloga za character ne radi, pa sam ovako probao
	@Test
	public void getSlovoTestC() {
		assertEquals("C", Character.toString(Slova.getSlova()[2]));
	}

	@Test
	public void getPoslednjeSlovo(){
		int indeksPoslednjeg = Slova.getSlova().length-1;
		assertEquals("Z", Character.toString(Slova.getSlova()[indeksPoslednjeg]));
	}
	
}
