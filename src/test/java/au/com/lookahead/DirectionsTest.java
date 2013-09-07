/**
 * 
 */
package au.com.lookahead;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ben
 * 
 */
public class DirectionsTest {

	private Robot robot;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	@Test
	public void testDirections() throws NotPlacedOrDirectedException,
			InvalidPositioningException {
		robot.place(0, 0, Direction.NORTH);
		assertEquals(robot.north().getDir(), Direction.NORTH);
		assertEquals(robot.south().getDir(), Direction.SOUTH);
		assertEquals(robot.east().getDir(), Direction.EAST);
		assertEquals(robot.west().getDir(), Direction.WEST);

		assertEquals(robot.direct(Direction.EAST).getDir(), Direction.EAST);
		assertEquals(robot.direct(Direction.WEST).getDir(), Direction.WEST);
		assertEquals(robot.direct(Direction.SOUTH).getDir(), Direction.SOUTH);
		assertEquals(robot.direct(Direction.NORTH).getDir(), Direction.NORTH);
	}

	@Test
	public void testLeftMoves() throws NotPlacedOrDirectedException,
			InvalidPositioningException {
		robot.place(0, 0, Direction.NORTH);
		assertEquals(robot.left().getDir(), Direction.WEST);
		assertEquals(robot.left().getDir(), Direction.SOUTH);
		assertEquals(robot.left().getDir(), Direction.EAST);
		assertEquals(robot.left().getDir(), Direction.NORTH);
	}

	@Test
	public void testRightMoves() throws NotPlacedOrDirectedException,
			InvalidPositioningException {
		robot.place(0, 0, Direction.NORTH);
		assertEquals(robot.right().getDir(), Direction.EAST);
		assertEquals(robot.right().getDir(), Direction.SOUTH);
		assertEquals(robot.right().getDir(), Direction.WEST);
		assertEquals(robot.right().getDir(), Direction.NORTH);
	}

	@Test
	public void testPlacing() throws InvalidPositioningException {
		robot.place(0, 1);
		assertEquals(robot.getX(), 0);
		assertEquals(robot.getY(), 1);

		robot.place(1, 2, Direction.NORTH);
		assertEquals(robot.getX(), 1);
		assertEquals(robot.getY(), 2);
		assertEquals(robot.getDir(), Direction.NORTH);
	}
}
