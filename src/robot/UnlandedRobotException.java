package robot;


public class UnlandedRobotException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnlandedRobotException() {
        super("Le robot doit etre pose avant tout deplacement");
    }
}
