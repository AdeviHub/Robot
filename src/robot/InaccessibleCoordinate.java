package robot;

public class InaccessibleCoordinate extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public InaccessibleCoordinate(Coordinates coordinate) {
    	System.out.println("COORDONNEES INACCESSIBLES !");
    }
}
