package robot;

public class InsufficientChargeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientChargeException() {
		System.out.println("PAS ASSEZ DE BATTERIE !");
	}
}
