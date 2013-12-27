package robot;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author De Gieter Antoine
 * @author Colin Arnaud
 * 
 * Teste les methodes de MapTools
 * 
 */
public class MapToolsUnitTest {

	@Test
	public void coordinatesNextForwardPositionTest() {
		
		/*
		 * Test sur les coordonnees avec Direction.NORTH
		 */
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.NORTH).getX() == new Coordinates(0, -1).getX());
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.NORTH).getY() == new Coordinates(0, -1).getY());

		/*
		 * Test sur les coordonnees avec Direction.SOUTH
		 */
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.SOUTH).getX() == new Coordinates(0, 1).getX());
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.SOUTH).getY() == new Coordinates(0, 1).getY());

		/*
		 * Test sur les coordonnees avec Direction.EAST
		 */
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.EAST).getX() == new Coordinates(1, 0).getX());
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.EAST).getY() == new Coordinates(1, 0).getY());

		/*
		 * Test sur les coordonnees avec Direction.WEST
		 */
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.WEST).getX() == new Coordinates(-1, 0).getX());
		assertTrue(MapTools.nextForwardPosition(new Coordinates(0, 0),
				Direction.WEST).getY() == new Coordinates(-1, 0).getY());
	}
	
	@Test
	public void coordinatesNextBackwardPositionTest() {
		
		/*
		 * Test sur les coordonnees avec Direction.NORTH
		 */
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.NORTH).getX() == new Coordinates(0, 1).getX());
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.NORTH).getY() == new Coordinates(0, 1).getY());

		/*
		 * Test sur les coordonnees avec Direction.SOUTH
		 */
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.SOUTH).getX() == new Coordinates(0, -1).getX());
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.SOUTH).getY() == new Coordinates(0, -1).getY());

		/*
		 * Test sur les coordonnees avec Direction.EAST
		 */
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.EAST).getX() == new Coordinates(-1, 0).getX());
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.EAST).getY() == new Coordinates(-1, 0).getY());

		/*
		 * Test sur les coordonnees avec Direction.WEST
		 */
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.WEST).getX() == new Coordinates(1, 0).getX());
		assertTrue(MapTools.nextBackwardPosition(new Coordinates(0, 0),
				Direction.WEST).getY() == new Coordinates(1, 0).getY());
	}
	
	@Test
	public void clockwiseTest() {
		assertTrue(MapTools.clockwise(Direction.NORTH) == Direction.EAST);
		assertTrue(MapTools.clockwise(Direction.EAST) == Direction.SOUTH);
		assertTrue(MapTools.clockwise(Direction.SOUTH) == Direction.WEST);
		assertTrue(MapTools.clockwise(Direction.WEST) == Direction.NORTH);
	}
	
	@Test
	public void counterClockwiseTest() {
		assertTrue(MapTools.counterclockwise(Direction.NORTH) == Direction.WEST);
		assertTrue(MapTools.counterclockwise(Direction.WEST) == Direction.SOUTH);
		assertTrue(MapTools.counterclockwise(Direction.SOUTH) == Direction.EAST);
		assertTrue(MapTools.counterclockwise(Direction.EAST) == Direction.NORTH);
	}
}
