package robot;

import java.util.Iterator;
import java.util.List;

public class RoadBook {
    private List<Instruction> instructions;
    private final Iterator<Instruction> instructionIterator;


    public RoadBook(List<Instruction> instructions) {
       this.setInstructions(instructions);
        instructionIterator = instructions.iterator();
    }


    public boolean hasInstruction() {
        return instructionIterator.hasNext();
    }

    public Instruction next() {
        return instructionIterator.next();
    }


	public List<Instruction> getInstructions() {
		return instructions;
	}


	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}


}
