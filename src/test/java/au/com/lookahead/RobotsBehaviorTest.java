/**
 * 
 */
package au.com.lookahead;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ben
 *
 */
public class RobotsBehaviorTest {

	private Robot robot;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	/**
	 * PLACE 0,0,NORTH
	 * MOVE
	 * REPORT
	 * Output: 0,1,NORTH
	 * @throws InvalidPositioningException 
	 */
	@Test
	public void testPlace00NorthMoveReport() {
		try {
			assertEquals(robot.place(0,0, Direction.NORTH).move().getReport(), "0,1,NORTH"); 
		} catch (InvalidPositioningException e) {
			e.printStackTrace();
			fail();
		} catch (NotPlacedOrDirectedException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * PLACE 0,0,NORTH
	 * LEFT
	 * REPORT
	 * Output: 0,0,WEST
	 * @throws InvalidPositioningException 
	 */
	@Test
	public void testPlace00NorthLeftReport() {
		try {
			assertEquals(robot.place(0, 0, Direction.NORTH).left().getReport(), "0,0,WEST");
		} catch (InvalidPositioningException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * PLACE 1,2,EAST
	 * MOVE
	 * MOVE
	 * LEFT
	 * MOVE
	 * REPORT
	 * Output: 3,3,NORTH
	 * @throws InvalidPositioningException 
	 */
	@Test
	public void testPlace1_2EastMoveMoveLeftReport() {
		try {
			assertEquals("3,3,NORTH", robot.place(1,2,Direction.EAST).move().move().left().move().getReport());
		} catch (InvalidPositioningException e) {
			e.printStackTrace();
			fail();
		} catch (NotPlacedOrDirectedException e) {
			e.printStackTrace();
			fail();
		}
	}	

	/**
	 * PLACE 1,2,SOUTH
	 * MOVE
	 * REPORT
	 * Output: 1,1,SOUTH
	 * @throws InvalidPositioningException 
	 */
	@Test
	public void testPlace1_2SouthMoveReport() {
		try {
			assertEquals("1,1,SOUTH", robot.place(1,2,Direction.SOUTH).move().getReport());
		} catch (InvalidPositioningException e) {
			e.printStackTrace();
			fail();
		} catch (NotPlacedOrDirectedException e) {
			e.printStackTrace();
			fail();
		}
	}	

	/**
	 * PLACE 1,2,WEST
	 * MOVE
	 * REPORT
	 * Output: 3,3,NORTH
	 * @throws InvalidPositioningException 
	 */
	@Test
	public void testPlace1_2WestMoveReport() {
		try {
			assertEquals("0,2,WEST", robot.place(1,2,Direction.WEST).move().getReport());
		} catch (InvalidPositioningException e) {
			e.printStackTrace();
			fail();
		} catch (NotPlacedOrDirectedException e) {
			e.printStackTrace();
			fail();
		}
	}	
}
