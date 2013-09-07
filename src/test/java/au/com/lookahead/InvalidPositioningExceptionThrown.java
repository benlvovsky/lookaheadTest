/**
 * 
 */
package au.com.lookahead;

import static org.junit.Assert.*;

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
public class InvalidPositioningExceptionThrown {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 5, 0 }, { 5, 1 }, { 5, 2 },
				{ 5, 3 }, { 5, 4 }, { 0, 5 }, { 1, 5 }, { 2, 5 }, { 3, 5 },
				{ 4, 5 }, { 5, 5 }, 
				{-1, 0}, {-1, -1}, {0, -1}
				});
	}

	private Robot robot;
	private Integer y = 0;
	private Integer x = 0;

	public InvalidPositioningExceptionThrown(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	/**
	 * Right positioning
	 * 
	 * @throws InvalidPositioningException
	 */
	@Test
	public void testNoInvalidPositioningException() {
		try {
			robot.place(x, y, Direction.NORTH);
			fail("Should have thrown an InvalidPositioningException!");
		} catch (InvalidPositioningException e) {
			assertTrue(e.getMessage().contains("x = " + x + ", y = " + y));
		}
	}

	@Test
	public void testValidatePositioningExceptionThrown() {
		try {
			robot.validatePositioning(x, y);
			fail("Should have thrown an InvalidPositioningException!");
		} catch (InvalidPositioningException e) {
			assertTrue(e.getMessage().contains("x = " + x + ", y = " + y));
		}
	}
}
