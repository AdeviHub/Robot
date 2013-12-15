package robot;

public class UndefinedRoadbookException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UndefinedRoadbookException() {
        super("Aucun road book défini");
    }
}
