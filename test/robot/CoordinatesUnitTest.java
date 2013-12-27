package robot;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author De Gieter Antoine
 * @author Colin Arnaud
 * 
 * Teste les methodes de Coordinates
 *
 */
public class CoordinatesUnitTest {

	@Test
	public void getXTest() {
		Coordinates c = new Coordinates(-7, 8);
		assertTrue(c.getX() == -7);
	}

	@Test
	public void getYTest() {
		Coordinates c = new Coordinates(-7, 8);
		assertTrue(c.getY() == 8);
	}
}
