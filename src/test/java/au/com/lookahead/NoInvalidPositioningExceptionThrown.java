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
public class NoInvalidPositioningExceptionThrown {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, 
                { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, 
                { 2, 0 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 2, 4 }, 
                { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 3 }, { 3, 4 }, 
                { 4, 0 }, { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, 
           });
    }

	private Robot robot;
	private Integer y = 0;
	private Integer x = 0;

	public NoInvalidPositioningExceptionThrown(Integer x, Integer y) {
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
	 * @throws InvalidPositioningException 
	 */
	@Test
	public void testNoInvalidPositioningException() {
		try {
			robot.place(x, y, Direction.NORTH);
		} catch (InvalidPositioningException e) {
			fail("Should not have thrown an InvalidPositioningException as value is correct");
		}
	}

	@Test
	public void testValidatePositioningNoException() {
		try {
			robot.validatePositioning(x, y);
		} catch (InvalidPositioningException e) {
			fail("Should not have an InvalidPositioningException thrown!");
		}
	}
}
