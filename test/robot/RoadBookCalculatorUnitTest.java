package robot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * @author De Gieter Antoine
 * @author Colin Arnaud
 * 
 *         Teste la methode de RoadBookCalculator
 * 
 */
public class RoadBookCalculatorUnitTest {

	@Test
	public void calculateRoadBookTest1() {
		ArrayList<Instruction> instructions = new ArrayList<Instruction>(), expectedResult = new ArrayList<Instruction>();
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.TURNRIGHT);
		expectedResult.add(Instruction.BACKWARD);
		RoadBook result;
		result = RoadBookCalculator.calculateRoadBook(Direction.SOUTH,
				new Coordinates(0, 0), new Coordinates(1, 1), instructions);
		for(Instruction i : result.getInstructions())
			System.out.println(i);
		for(int i = 0; i < result.getInstructions().size(); i++) {
			assertTrue(result.getInstructions().get(i) == expectedResult.get(i));
		}
	}
	
	@Test
	public void calculateRoadBookTest2() {
		ArrayList<Instruction> instructions = new ArrayList<Instruction>(), expectedResult = new ArrayList<Instruction>();
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.FORWARD);
		expectedResult.add(Instruction.TURNLEFT);
		expectedResult.add(Instruction.BACKWARD);
		expectedResult.add(Instruction.BACKWARD);
		expectedResult.add(Instruction.BACKWARD);
		RoadBook result;
		result = RoadBookCalculator.calculateRoadBook(Direction.SOUTH,
				new Coordinates(0, 0), new Coordinates(-3, 7), instructions);
		for(int i = 0; i < result.getInstructions().size(); i++) {
			assertTrue(result.getInstructions().get(i) == expectedResult.get(i));
		}
	}
}
