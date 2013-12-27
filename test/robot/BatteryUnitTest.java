package robot;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author De Gieter Antoine
 * @author Colin Arnaud
 * 
 * Teste les methodes de Battery
 *
 */
public class BatteryUnitTest {
	
	@Test
	public void constructorTest() {
		Battery b = new Battery();
		assertTrue(b.getChargeLevel() == 100);
	}
	
	@Test
	public void chargeTest() {
		Battery b = new Battery();
		b.charge();
		assertTrue(b.getChargeLevel() == 110);
	}
	
	@Test
	public void useTest() {
		Battery b = new Battery();
		try {
			b.use(10.0);
		} catch (InsufficientChargeException e) {}
		catch (NegativeEnergyException e) {}
		finally {
			assertTrue(b.getChargeLevel() == 90);
		}
		
		try {
			b.use(-120.0);
		} catch (InsufficientChargeException e) {}
		catch (NegativeEnergyException e) {}
		finally {
			assertTrue(b.getChargeLevel() == 90);
		}
		
		try {
			b.use(250.0);
			System.out.println(b.getChargeLevel());
		} catch (InsufficientChargeException e) {}
		catch (NegativeEnergyException e) {}
		finally {
			assertTrue(b.getChargeLevel() == 90);
		}
	}
	
	@Test
	public void setUpTest() {
		Battery b = new Battery();
        b.setUp();
        try {
        	Thread.sleep(2000);
        } catch(InterruptedException e) {}
        assertTrue(b.getChargeLevel() == 120);
	}
	
	@Test
	public void timeToSufficientChargeTest() {
		Battery b = new Battery();
		assertTrue(b.timeToSufficientCharge(100) == 0);
        assertTrue(b.timeToSufficientCharge(150) == 5000);
	}
	
	@Test
	public void canDeliverTest() {
		Battery b = new Battery();
		assertFalse(b.canDeliver(150));
		assertTrue(b.canDeliver(50));
    }
}
