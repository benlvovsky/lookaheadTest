package au.com.lookahead;

public class Robot {

	private static final int MAXY = 4;
	private static final int MINY = 0;
	private static final int MAXX = 4;
	private static final int MINX = 0;
	private Integer x = 0;
	private Integer y = 0;
	private Boolean isPlaced = false;
	private Boolean isDirected = false;
	private Direction dir = Direction.NORTH;

	public Robot() {
		isPlaced = false; // initially the robot is not placed
		isDirected = false; // initially the robot is not directed anywhere and does not know where to go
	}

	/**
	 * Place and set direction method
	 * 
	 * @param i
	 * @param j
	 * @param direction
	 * @return
	 * @throws InvalidPositioningException
	 */
	public Robot place(int i, int j, Direction direction)
			throws InvalidPositioningException {
		validatePositioning(i, j);
		x = i;
		y = j;
		dir = direction;
		isPlaced = true;
		isDirected = true;
		return this;
	}

	/**
	 * Place method to place the Robot
	 * 
	 * @param i
	 * @param j
	 * @param direction
	 * @return
	 * @throws InvalidPositioningException
	 */
	public Robot place(int i, int j)
			throws InvalidPositioningException {
		validatePositioning(i, j);
		x = i;
		y = j;
		isPlaced = true;
		return this;
	}

	/**
	 * Validates positioning and throws exception if it is wrong
	 * 
	 * @param i
	 * @param j
	 * @throws InvalidPositioningException
	 */
	public void validatePositioning(Integer i, Integer j)
			throws InvalidPositioningException {
		if (i < MINX || i > MAXX || j < MINY || j > MAXY) {
			throw new InvalidPositioningException(i, j);
		}
	}

	/**
	 * north facing
	 * 
	 * @return
	 * @throws NotPlacedOrDirectedException
	 */
	public Robot north() throws NotPlacedOrDirectedException {
		direct(Direction.NORTH);
		return this;
	}

	/**
	 * north facing
	 * 
	 * @return
	 * @throws NotPlacedOrDirectedException
	 */
	public Robot south() throws NotPlacedOrDirectedException {
		direct(Direction.SOUTH);
		return this;
	}

	/**
	 * north facing
	 * 
	 * @return
	 * @throws NotPlacedOrDirectedException
	 */
	public Robot west() throws NotPlacedOrDirectedException {
		direct(Direction.WEST);
		return this;
	}

	/**
	 * north facing
	 * 
	 * @return
	 * @throws NotPlacedOrDirectedException
	 */
	public Robot east() throws NotPlacedOrDirectedException {
		direct(Direction.EAST);
		return this;
	}

	/**
	 * turning left from the currently faced direction
	 * @return this
	 * @throws InvalidDirectionException 
	 */
	public Robot left() {
		switch (dir) {
		case NORTH:
			dir = Direction.WEST;
			break;
		case SOUTH:
			dir = Direction.EAST;
			break;
		case WEST:
			dir = Direction.SOUTH;
			break;
		case EAST:
			dir = Direction.NORTH;
			break;
		}
		return this;
	}

	/**
	 * turning right from the currently faced direction
	 * @return this
	 * @throws InvalidDirectionException 
	 */
	public Robot right() {
		switch (dir) {
		case NORTH:
			dir = Direction.EAST;
			break;
		case SOUTH:
			dir = Direction.WEST;
			break;
		case WEST:
			dir = Direction.NORTH;
			break;
		case EAST:
			dir = Direction.SOUTH;
			break;
		}
		return this;
	}

	/**
	 * facing specified direction
	 * 
	 * @return
	 * @throws NotPlacedOrDirectedException
	 */
	public Robot direct(Direction direction) {
		dir = direction;
		isDirected = true;
		return this;
	}

	/**
	 * validation of placing and direction
	 * Note: if the robot hasn't been placed and directed 
	 * it cannot perform as it is in undefined state 
	 * @throws NotPlacedOrDirectedException
	 */
	public void validatePlacedAndDirected() throws NotPlacedOrDirectedException {
		if (!isPlaced || !isDirected) {
			throw new NotPlacedOrDirectedException(isPlaced, isDirected);
		}
	}

	/**
	 * returns reporting string
	 * @return reportString
	 * @throws NotPlacedOrDirectedException 
	 */
	public String getReport() throws NotPlacedOrDirectedException {
		validatePlacedAndDirected();
		return x.toString() + "," + y.toString() + "," + this.dir;
	}

	/**
	 * Move one spot to the facing direction
	 * 
	 * @return
	 * @throws InvalidPositioningException
	 * @throws NotPlacedOrDirectedException 
	 * @throws InvalidDirectionException 
	 */
	public Robot move() throws InvalidPositioningException, NotPlacedOrDirectedException {
		validatePlacedAndDirected();
		int newX = x;
		int newY = y;
		switch (dir) {
		case NORTH:
			newY = y + 1;
			break;
		case SOUTH:
			newY = y - 1;
			break;
		case WEST:
			newX = x - 1;
			break;
		case EAST:
			newX = x + 1;
			break;
		}
		validatePositioning(newX, newY);
		x = newX;
		y = newY;
		return this;
	}

	/**
	 * getter for direction
	 * @return dir
	 */
	public Direction getDir() {
		return dir;
	}

	/**
	 * getter for X coordinate
	 * @return
	 */
	public Object getX() {
		return x;
	}
	
	/**
	 * getter for Y coordinate
	 * @return
	 */
	public Object getY() {
		return y;
	}
}
