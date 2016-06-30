package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper {
	/** User interface. */
	private UserInterface userInterface;

	private long startMillis;
	private BestTimes bestTimes;

	private static Minesweeper instance;

	public BestTimes getBestTimes() {
		return bestTimes;
	}

	/**
	 * Constructor.
	 */
	private Minesweeper() {
		instance = this;
		userInterface = new ConsoleUI();

		Field field = new Field(9, 9, 10);
		startMillis = System.currentTimeMillis();
		userInterface.newGameStarted(field);
	}

	public static Minesweeper getInstance() {
		if (instance == null) {
			return new Minesweeper();

		} else {
			return instance;
		}
	}

	/**
	 * Get playing time
	 * 
	 * @return int in seconds of playing
	 */
	public int getPlayingSeconds() {
		int currentTime = (int) ((System.currentTimeMillis() - startMillis)/1000L);
		return currentTime;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Minesweeper();

	}
}
