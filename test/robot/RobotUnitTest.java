package robot;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RobotUnitTest {
	public Robot robot;
	public Random t;

	@Test
	public void landTest() {
		this.robot = new Robot();
		this.robot.land(new Coordinates(0, 0), new LandSensor(new Random()));
		try {
			assertTrue(this.robot.getXposition() == 0);
			assertTrue(this.robot.getYposition() == 0);
			assertTrue(this.robot.getDirection() == Direction.NORTH);
		} catch (UnlandedRobotException e) {
		}
	}

	@Test
	public void getXpositionTest() {
		this.robot = new Robot();
		this.robot.land(new Coordinates(-12, 4), new LandSensor(new Random()));
		try {
			assertTrue(this.robot.getXposition() == -12);
		} catch (UnlandedRobotException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getYpositionTest() {
		this.robot = new Robot();
		this.robot.land(new Coordinates(-12, 4), new LandSensor(new Random()));
		try {
			assertTrue(this.robot.getYposition() == 4);
		} catch (UnlandedRobotException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDirectionTest() {
		this.robot = new Robot();
		this.robot.land(new Coordinates(-12, 4), new LandSensor(new Random()));
		try {
			assertTrue(this.robot.getDirection() == Direction.NORTH);
		} catch (UnlandedRobotException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void moveForwardTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		this.robot.land(new Coordinates(0, 0), new LandSensor(t));
		try {
			this.robot.moveForward();
		} catch (UnlandedRobotException e) {
		} catch (InsufficientChargeException e) {
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		} catch (NegativeEnergyException e) {
		}

		try {
			assertTrue(this.robot.getXposition() == 0);
			assertTrue(this.robot.getYposition() == -1);
			assertTrue(this.robot.getDirection() == Direction.NORTH);
		} catch (UnlandedRobotException e) {
		}
	}

	@Test
	public void moveBackwardTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		this.robot.land(new Coordinates(0, 0), new LandSensor(t));
		try {
			this.robot.moveBackward();
		} catch (UnlandedRobotException e) {
		} catch (InsufficientChargeException e) {
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		} catch (NegativeEnergyException e) {
		}

		try {
			assertTrue(this.robot.getXposition() == 0);
			assertTrue(this.robot.getYposition() == 1);
			assertTrue(this.robot.getDirection() == Direction.NORTH);
		} catch (UnlandedRobotException e) {
		}
	}

	@Test
	public void turnLeftTest() throws InsufficientChargeException,
			LandSensorDefaillance {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		this.robot.land(new Coordinates(0, 0), new LandSensor(t));
		try {
			robot.turnLeft();
		} catch (UnlandedRobotException e) {
		}

		try {
			assertTrue(this.robot.getXposition() == 0);
			assertTrue(this.robot.getYposition() == 0);
			assertTrue(this.robot.getDirection() == Direction.WEST);
		} catch (UnlandedRobotException e) {
		}
	}

	@Test
	public void turnRightTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		this.robot.land(new Coordinates(0, 0), new LandSensor(t));
		try {
			robot.turnRight();
		} catch (UnlandedRobotException e) {
		}

		try {
			assertTrue(this.robot.getXposition() == 0);
			assertTrue(this.robot.getYposition() == 0);
			assertTrue(this.robot.getDirection() == Direction.EAST);
		} catch (UnlandedRobotException e) {
		}
	}

	@Test
	public void lestGoTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		Coordinates c = new Coordinates(0, 0);
		this.robot.land(c, new LandSensor(t));
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.FORWARD);
		instructions.add(Instruction.TURNLEFT);
		instructions.add(Instruction.BACKWARD);
		instructions.add(Instruction.TURNRIGHT);
		instructions.add(Instruction.FORWARD);
		this.robot.setRoadBook(new RoadBook(instructions));
		try {
			this.robot.letsGo();
			assertTrue(this.robot.getXposition() == 1);
			assertTrue(this.robot.getYposition() == -2);
			assertTrue(this.robot.getDirection() == Direction.NORTH);
		} catch (UnlandedRobotException e) {
		} catch (UndefinedRoadbookException e) {
		} catch (InsufficientChargeException e) {
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		} catch (NegativeEnergyException e) {
		}
	}
	
	@Test
	public void setNullRoadBookTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		Coordinates c = new Coordinates(0, 0);
		this.robot.land(c, new LandSensor(t));
		try {
			robot.setRoadBook(null);
		} catch(Exception e) {
			assertTrue(e instanceof UndefinedRoadbookException);
		}
	}
	
	@Test
	public void setRoadBookTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
		Coordinates c = new Coordinates(0, 0);
		List<Instruction> instructions = new ArrayList<Instruction>();
		this.robot.land(c, new LandSensor(t));
		this.robot.setRoadBook(new RoadBook(instructions));
	}
	
	@Test
	public void computeRoadToTest() {
		this.robot = new Robot();
		this.t = mock(Random.class);
		when(t.nextInt(anyInt())).thenReturn(0);
        Coordinates src = new Coordinates(0,0);
        Coordinates dst = new Coordinates(2,2);
        this.robot.land(src, new LandSensor(t));
        try {
			this.robot.computeRoadTo(dst);
			this.robot.letsGo();
	        assertTrue(this.robot.getXposition() == 2);
	        assertTrue(this.robot.getYposition() == 2);
		} catch (UnlandedRobotException e) {
		} catch (UndefinedRoadbookException e) {
		} catch (InsufficientChargeException e) {
		} catch (LandSensorDefaillance e) {
		} catch (InaccessibleCoordinate e) {
		} catch (NegativeEnergyException e) {
		}
	}
	
	@Test
	public void unlandedExceptionTest() {
		this.robot = new Robot();
		try {
			robot.moveForward();
		} catch (Exception e) {
			assertTrue(e instanceof UnlandedRobotException);
		}
		try {
			robot.moveBackward();
		} catch (Exception e) {
			assertTrue(e instanceof UnlandedRobotException);
		}
		try {
			robot.turnLeft();
		} catch (Exception e) {
			assertTrue(e instanceof UnlandedRobotException);
		}
		try {
			robot.turnRight();
		} catch (Exception e) {
			assertTrue(e instanceof UnlandedRobotException);
		}
	}
}
