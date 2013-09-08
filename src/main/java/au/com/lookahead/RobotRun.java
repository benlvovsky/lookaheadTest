package au.com.lookahead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RobotRun {

	private Robot robot;
	public final static String[] allowedFacings = new String[] { "NORTH",
			"WEST", "SOUTH", "EAST" };;

	public RobotRun() {
		robot = new Robot();
	}

	public static void main(String args[]) {
		RobotRun rr = new RobotRun();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input;

			while ((input = br.readLine()) != null) {
				String outputString = rr.processCommand(input);
				if(outputString.length() > 0) {
					System.out.println(outputString);
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	protected String processCommand(String input) {
		String splt[] = input.split(" ");
		String retVal = "";
		if (splt.length == 2 && "PLACE".equalsIgnoreCase(splt[0])) {
			retVal = doPlace(input, splt);
		} else if (splt.length == 1 && "MOVE".equalsIgnoreCase(splt[0])) {
			retVal = doMove(input);
		} else if (splt.length == 1 && "LEFT".equalsIgnoreCase(splt[0])) {
			robot.left();
		} else if (splt.length == 1 && "RIGHT".equalsIgnoreCase(splt[0])) {
			robot.right();
		} else if (splt.length == 1 && "REPORT".equalsIgnoreCase(splt[0])) {
			retVal = doReport();
		} else {
			retVal = "Wrong command format \"" + input + "\"";
		}
		return retVal;
	}

	/**
	 * @return
	 * @throws NotPlacedOrDirectedException
	 */
	private String doReport() {
		String retVal = "";
		try {
			retVal = "Output: " + robot.getReport();
		} catch (NotPlacedOrDirectedException e) {
			retVal = "Robot not placed or directed";
		}
		return retVal;
	}

	/**
	 * @param input
	 * @param splt
	 * @param retVal
	 * @return
	 */
	private String doPlace(String input, String[] splt) {
		String retVal = "";
		String placePrm[] = splt[1].split(",");
		if (placePrm.length == 3) {
			try {
				Integer x = Integer.valueOf(placePrm[0]);
				Integer y = Integer.valueOf(placePrm[1]);
				String facing = placePrm[2];
					if (facing.equalsIgnoreCase("NORTH")) {
						robot.place(x, y, Direction.NORTH);
					} else if (facing.equalsIgnoreCase("EAST")) {
						robot.place(x, y, Direction.EAST);
					} else if (facing.equalsIgnoreCase("WEST")) {
						robot.place(x, y, Direction.WEST);
					} else if (facing.equalsIgnoreCase("SOUTH")) {
						robot.place(x, y, Direction.SOUTH);
					} else {
						retVal = "Wrong FACING. Allowed FACING are: \""
								+ allowedFacings + "\"";
					}
			} catch (NumberFormatException e) {
				retVal = "Wrong PLACE Integer format. First 2 arguments have to be integers \""
						+ input + "\"";
			} catch (InvalidPositioningException e) {
				retVal = "Invalid Positioning in command \"" + input + "\"";
			}
		} else {
			retVal = "Wrong PLACE format. Has to be comadelimited 3 parameters \""
					+ input + "\"";
		}
		return retVal;
	}

	/**
	 * @param input
	 * @return
	 */
	private String doMove(String input) {
		String retVal = "";
		try {
			robot.move();
		} catch (InvalidPositioningException e) {
			retVal = "Invalid Positioning in command \"" + input + "\"";
		} catch (NotPlacedOrDirectedException e) {
			retVal = "Robot not placed or directed";
		}
		return retVal;
	}
}
