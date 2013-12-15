package robot;

/**
 * 
 * @author antoine
 *
 */
public class InaccessibleCoordinate extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coordinates coordinate;

    public InaccessibleCoordinate(Coordinates coordinate) {
        this.setCoordinate(coordinate);
    }

	public Coordinates getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinates coordinate) {
		this.coordinate = coordinate;
	}
}
