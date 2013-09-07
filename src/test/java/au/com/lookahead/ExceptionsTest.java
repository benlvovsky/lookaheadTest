package au.com.lookahead;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExceptionsTest {

	@Test
	public void testInvalidPositioningException() {
		InvalidPositioningException e = new InvalidPositioningException(5, 5);
		assertTrue(e.getMessage().contains("x = 5, y = 5"));
	}

	@Test
	public void testNotPlacedOrDirectedException() {
		NotPlacedOrDirectedException e = new NotPlacedOrDirectedException(false, false);
		assertTrue(e.getMessage().contains("isPlaced = false, isDirected = false"));
		e = new NotPlacedOrDirectedException(true, false);
		assertTrue(e.getMessage().contains("isPlaced = true, isDirected = false"));
		e = new NotPlacedOrDirectedException(false, true);
		assertTrue(e.getMessage().contains("isPlaced = false, isDirected = true"));
	}
}
