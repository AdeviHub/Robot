package robot;


import java.util.Random;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * 
 * @author De Gieter Antoine
 * @author Colin Arnaud
 * 
 *         Teste les methodes de LandSensor
 * 
 */
public class LandSensorUnitTest {
	private LandSensor ls;
	private Random rdm;
	private Coordinates depart, arrivee;

	@Test
	public void getPointToPointEnergyCoefficientNRTest() {
		rdm = mock(Random.class);
		when(rdm.nextInt(anyInt())).thenReturn(-6);
		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(0, 0);

		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientTest() {
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(3, -1);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(0, 0);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
	/*
	@Test
	public void testgptpecToutNoeud3() {
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(3, 5);
		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}

	}

	@Test
	public void testgptpecToutNoeud4() {
		double result;

		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);

		try {
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertEquals("Ca devrait faire ~1", 1, result, 0.001);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}

	@Test
	public void testgptpecToutArcs() {
		double result;

		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertEquals("Ca devrait faire ~1", 1, result, 0.001);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}

	@Test
	public void testgptpecToutCheminLI() {
		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
		arrivee = new Coordinates(0, 1);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}/**/
}
