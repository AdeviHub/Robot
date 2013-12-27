package robot;

import java.util.ArrayList;
import java.util.List;

public class RoadBookCalculator {

	static RoadBook calculateRoadBook(Direction direction,
			Coordinates position, Coordinates destination,
			ArrayList<Instruction> instructions) {
		List<Direction> directionList = new ArrayList<Direction>();
		if (destination.getX() < position.getX())
			directionList.add(Direction.WEST);
		if (destination.getX() > position.getX())
			directionList.add(Direction.EAST);

		/*
		 * Toujours l'inverse pour le nord et le sud
		 */
		if (destination.getY() < position.getY())
			directionList.add(Direction.NORTH);
		if (destination.getY() > position.getY())
			directionList.add(Direction.SOUTH);

		/*
		 * Si position et destination sont egaux
		 */
		if (directionList.isEmpty())
			return new RoadBook(instructions);

        /*
         * Gestion de la prochaine instruction a prendre
         */
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(directionList.contains(direction));
		if (directionList.contains(direction)) {
			instructions.add(Instruction.FORWARD);
            return calculateRoadBook(direction,
                MapTools.nextForwardPosition(position, direction), destination, instructions);
        } else if ((directionList.contains(Direction.NORTH)
                && direction == Direction.SOUTH)
                || (directionList.contains(Direction.SOUTH)
                && direction == Direction.NORTH)
                || (directionList.contains(Direction.EAST)
                && direction == Direction.WEST)
                || (directionList.contains(Direction.WEST)
                && direction == Direction.EAST)) {
            instructions.add(Instruction.BACKWARD);
            return calculateRoadBook(direction,
                MapTools.nextBackwardPosition(position, direction), destination, instructions);
        } else if ((directionList.contains(Direction.NORTH)
				&& direction == Direction.EAST)
                || (directionList.contains(Direction.SOUTH)
                && direction == Direction.WEST)
                || (directionList.contains(Direction.WEST)
                && direction == Direction.NORTH)
                || (directionList.contains(Direction.EAST)
                && direction == Direction.SOUTH)) {
			instructions.add(Instruction.TURNRIGHT);
            return calculateRoadBook(MapTools.clockwise(direction),
                position, destination, instructions);
        } else if ((directionList.contains(Direction.NORTH)
				&& direction == Direction.WEST)
                || (directionList.contains(Direction.SOUTH)
                && direction == Direction.EAST)
                || (directionList.contains(Direction.EAST)
                && direction == Direction.NORTH)
                || (directionList.contains(Direction.WEST)
                && direction == Direction.SOUTH)) {
			instructions.add(Instruction.TURNLEFT);
            return calculateRoadBook(MapTools.counterclockwise(direction),
                position, destination, instructions);
        } else {
        	return null;
        }
	}
}