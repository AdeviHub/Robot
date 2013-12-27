package robot;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author De Gieter Antoine
 * @author Colin Arnaud
 *
 * Teste les methodes de Land
 *
 */
public class LandUnitTest {

    @Test
    public void getLandByOrdinalTest() {
        Land l;
        
        try {
	        l = Land.getLandByOrdinal(0);
	        assertTrue(l.equals(Land.Terre));
	        l = Land.getLandByOrdinal(1);
	        assertTrue(l.equals(Land.Roche));
	        l = Land.getLandByOrdinal(2);
	        assertTrue(l.equals(Land.Sable));
	        l = Land.getLandByOrdinal(3);
	        assertTrue(l.equals(Land.Boue));
	        l = Land.getLandByOrdinal(4);
	        assertTrue(l.equals(Land.Infranchissable));
        } catch (TerrainNonRepertorieException e) {}

        try {
        	Land.getLandByOrdinal(6);
        } catch (TerrainNonRepertorieException e) {}
        
        try {
        	Land.getLandByOrdinal(-6);
        } catch (TerrainNonRepertorieException e) {}
    }

    @Test
    public void testCountLand() {
    	assertTrue(Land.CountLand() == 5);
    }
}
