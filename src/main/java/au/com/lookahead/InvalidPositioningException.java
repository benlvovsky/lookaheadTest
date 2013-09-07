package au.com.lookahead;

public class InvalidPositioningException extends Exception {
	private Integer x;
	private Integer y;
	
	public InvalidPositioningException(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String getMessage() {
		return "Wrong expected position with attempted values: x = " + x + ", y = " + y;
	}
}
