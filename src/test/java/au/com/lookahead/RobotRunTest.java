/**
 * 
 */
package au.com.lookahead;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ben
 *
 */
public class RobotRunTest {

	private RobotRun rr;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rr = new RobotRun();
	}

	@Test
	public void testProcessCommand1() {
		assertEquals("", rr.processCommand("PLACE 0,0,NORTH"));
		assertEquals("", rr.processCommand("LEFT"));
		assertEquals("Output: 0,0,WEST", rr.processCommand("REPORT"));
	}

	@Test
	public void testProcessCommand2() {
		assertEquals("", rr.processCommand("PLACE 0,0,NORTH"));
		assertEquals("", rr.processCommand("MOVE"));
		assertEquals("Output: 0,1,NORTH", rr.processCommand("REPORT"));
	}

	@Test
	public void testProcessCommand3() {
		assertEquals("", rr.processCommand("PLACE 1,2,EAST"));
		assertEquals("", rr.processCommand("MOVE"));
		assertEquals("", rr.processCommand("MOVE"));
		assertEquals("", rr.processCommand("LEFT"));
		assertEquals("", rr.processCommand("MOVE"));
		assertEquals("Output: 3,3,NORTH", rr.processCommand("REPORT"));
	}

	@Test
	public void testProcessCommand4() {
		assertEquals("", rr.processCommand("PLACE 0,0,NORTH"));
		assertEquals("", rr.processCommand("RIGHT"));
		assertEquals("Output: 0,0,EAST", rr.processCommand("REPORT"));
	}

	@Test
	public void testProcessCommand5() {
		assertEquals("", rr.processCommand("PLACE 1,1,WEST"));
		assertEquals("", rr.processCommand("RIGHT"));
		assertEquals("Output: 1,1,NORTH", rr.processCommand("REPORT"));
	}

	@Test
	public void testProcessCommand6() {
		assertEquals("", rr.processCommand("PLACE 1,1,SOUTH"));
		assertEquals("", rr.processCommand("RIGHT"));
		assertEquals("Output: 1,1,WEST", rr.processCommand("REPORT"));
	}

	@Test
	public void testProcessCommand7() {
		assertEquals("Robot not placed or directed", rr.processCommand("MOVE"));
	}

	@Test
	public void testProcessCommand8() {
		assertEquals("", rr.processCommand("PLACE 0,0,SOUTH"));
		assertTrue(rr.processCommand("MOVE").contains("Invalid Positioning"));
	}

	@Test
	public void testProcessCommand9() {
		assertTrue(rr.processCommand("REPORT").contains("not placed or directed"));
	}

	@Test
	public void testProcessCommand_errors() {
		assertTrue(rr.processCommand("PLACE 5,6,NORTH").contains("Invalid Positioning"));
		assertTrue(rr.processCommand("PLACE 0,0,SOMESTRANGEDIRECTION").contains("Wrong FACING. Allowed FACING are"));
		assertTrue(rr.processCommand("SHMACE 0,0,NORTH").contains("Wrong command"));
		assertTrue(rr.processCommand("PLACE 0 0,NORTH").contains("Wrong command"));
		assertTrue(rr.processCommand("PLACE 0,0,0,NORTH").contains("Wrong PLACE format"));
		assertTrue(rr.processCommand("PLACE l,0,NORTH").contains("Wrong PLACE Integer"));
		assertTrue(rr.processCommand("GO").contains("Wrong command"));
		assertTrue(rr.processCommand("REPORT ALL").contains("Wrong command"));
	}
}
