/**
 * 
 */
package au.com.lookahead;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author ben
 * 
 */
@RunWith(Parameterized.class)
public class PlacedOrDirectedExceptionThrown {

	private Robot robot;
	private Direction dir;
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { {Direction.EAST}, {Direction.NORTH}, {Direction.SOUTH}, {Direction.WEST} });
    };

    public PlacedOrDirectedExceptionThrown(Direction dir) {
    	this.dir = dir;
    }

    /**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	@Test
	public void testNotPlacedOrDirectedExceptionFalseFalseThrown() throws InvalidPositioningException {
		try {
			robot.move();
			fail("Supposed to throw NotPlacedOrDirectedException ");
		} catch (NotPlacedOrDirectedException e) {
			assertTrue(e.getMessage().contains("isPlaced = false, isDirected = false"));
		}
	}

	@Test
	public void testNotPlacedOrDirectedExceptionTrueFalseThrown() throws InvalidPositioningException {
		try {
			robot.place(0,  0);
			robot.move();
			fail("Supposed to throw NotPlacedOrDirectedException ");
		} catch (NotPlacedOrDirectedException e) {
			assertTrue(e.getMessage().contains("isPlaced = true, isDirected = false"));
		}
	}

	@Test
	public void testNotPlacedOrDirectedExceptionFalseTrueThrown() throws InvalidPositioningException {
		try {
			robot.direct(dir);
			robot.move();
			fail("Supposed to throw NotPlacedOrDirectedException ");
		} catch (NotPlacedOrDirectedException e) {
			assertTrue(e.getMessage().contains("isPlaced = false, isDirected = true"));
		}
	}

	@Test
	public void testNotPlacedOrDirectedExceptionTrueTrueNotThrown() throws InvalidPositioningException {
		try {
			robot.place(1, 1);
			robot.direct(dir);
			robot.move();
		} catch (NotPlacedOrDirectedException e) {
			fail("Should not throw NotPlacedOrDirectedException");
		}
	}

	@Test
	public void testValidatePlacedAndDirectedPlacedOnly() throws InvalidPositioningException {
		try {
			robot.place(1, 1);
			robot.validatePlacedAndDirected();
			fail("Should NotPlacedOrDirectedException");
		} catch (NotPlacedOrDirectedException e) {
			assertTrue(e.getMessage().contains("isPlaced = true, isDirected = false"));
		}
	}

	@Test
	public void testValidatePlacedAndDirectedDirectedOnly() throws InvalidPositioningException {
		try {
			robot.direct(dir);
			robot.validatePlacedAndDirected();
			fail("Should NotPlacedOrDirectedException");
		} catch (NotPlacedOrDirectedException e) {
			assertTrue(e.getMessage().contains("isPlaced = false, isDirected = true"));
		}
	}

	@Test
	public void testValidatePlacedAndDirectedTrueTrue() throws InvalidPositioningException {
		try {
			robot.place(0, 0, dir);
			robot.validatePlacedAndDirected();
		} catch (NotPlacedOrDirectedException e) {
			fail("Should not thown NotPlacedOrDirectedException exception");
		}
	}
}
