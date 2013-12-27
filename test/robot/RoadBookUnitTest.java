package robot;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author De Gieter Antoine
 * @author Colin Arnaud
 * 
 *         Teste les methodes de RoadBook
 * 
 */
public class RoadBookUnitTest {
	private RoadBook rb;

	@Test
	public void hasInstructionTest() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		rb = new RoadBook(instructions);
		// parce que c'est vide du coup
		assertFalse(rb.hasInstruction());

		instructions.add(Instruction.TURNLEFT);
		rb = new RoadBook(instructions);
		assertTrue(rb.hasInstruction());
	}

	@Test
	public void nextTest() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.TURNLEFT);
		rb = new RoadBook(instructions);
		assertTrue(rb.next() == Instruction.TURNLEFT);
	}
}