package au.com.lookahead;

public class NotPlacedOrDirectedException extends Exception {

	private Boolean isPlaced;
	private Boolean isDirected;

	public NotPlacedOrDirectedException(Boolean isPlaced, Boolean isDirected) {
		this.isPlaced = isPlaced; 
		this.isDirected = isDirected; 
	}
	
	@Override
	public String getMessage() {
		return "The Robot has to be placed and directed before use. isPlaced = " + isPlaced + ", isDirected = " + isDirected;
	}
}
