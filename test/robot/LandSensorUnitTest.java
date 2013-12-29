package robot;


import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;
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
	public void getPointToPointEnergyCoefficientNonRerpertorieTest() {
		rdm = mock(Random.class);
		when(rdm.nextInt(anyInt())).thenReturn(-6);
		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(0, 0);

		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (Exception e) {
			assertTrue(e instanceof LandSensorDefaillance);
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientTest() {
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(1, -6);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(0, 0);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (Exception e) {
			assertTrue(e instanceof LandSensorDefaillance);
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientInaccessibleCoordinatesTest() {
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(4);
		ls = new LandSensor(rdm);
		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);
		try {
			ls.getPointToPointEnergyCoefficient(depart, arrivee);
		} catch (Exception e) {
			assertTrue(e instanceof InaccessibleCoordinate);
		}

	}
	
	@Test
	public void getPointToPointEnergyCoefficientTerreTest() {
		double result;
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(0);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);

		try {
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertTrue(result == 1.0);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientRocheTest() {
		double result;
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(1);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);

		try {
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertTrue(result == 2.0);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientSableTest() {
		double result;
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(2);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);

		try {
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertTrue(result == 4.0);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientBoueTest() {
		double result;
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(3);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(1, 0);

		try {
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertTrue(result == 3.0);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
	
	@Test
	public void getPointToPointEnergyCoefficientCheminTest() {
		double result;
		rdm = mock(Random.class);
        when(rdm.nextInt(anyInt())).thenReturn(1, 2, 0, 3, 2, 2, 1, 0, 0, 1, 2);
		ls = new LandSensor(rdm);

		depart = new Coordinates(0, 0);
		arrivee = new Coordinates(-3, 8);

		try {
			result = ls.getPointToPointEnergyCoefficient(depart, arrivee);
			assertTrue(result == 3.0);
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		}
	}
}
