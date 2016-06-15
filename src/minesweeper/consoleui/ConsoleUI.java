package minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.UserInterface;
import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.Mine;
import minesweeper.core.Tile;
import minesweeper.core.Tile.State;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
	/** Playing field. */
	private Field field;

	/** Input reader. */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Reads line of text from the reader.
	 * 
	 * @return line as a string
	 */
	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field
	 * )
	 */
	@Override
	public void newGameStarted(Field field) {
		this.field = field;
		update();
		// do {
		// update();
		processInput();
		// // throw new
		// //
		// UnsupportedOperationException("Resolve the game state - winning or loosing condition.");
		// } while (true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
	@Override
	public void update() {
		Tile tile;
		displayFirstRow();

		char rowChar = 'A';
		for (int row = 0; row < field.getRowCount(); row++) {
			System.out.print(rowChar + " ");
			rowChar++;
			for (int column = 0; column < field.getColumnCount(); column++) {
				tile = field.getTile(row, column);
				if (tile.getState() == State.OPEN) {
					if (tile instanceof Mine) {
						System.out.print("  X");
					} else if (tile instanceof Clue) {
						System.out.print("  " + (((Clue) tile).getValue()));
					}
				} else if (tile.getState() == State.CLOSED) {
					System.out.print("  -");
				} else if (tile.getState() == State.MARKED) {
					System.out.print("  M");
				}
			}
			System.out.println();
		}
	}

	private void displayFirstRow() {
		System.out.print("  ");
		for (int i = 0; i < field.getColumnCount(); i++) {
			System.out.printf("  %d", i);
		}
		System.out.println();
	}

	/**
	 * Processes user input. Reads line from console and does the action on a
	 * playing field according to input string.
	 */
	private void processInput() {
		System.out
				.println("Please enter your selection (X) EXIT, (MA2) MARK, (OA2) OPEN ");
		Scanner inputStream = new Scanner(System.in);
		String input = inputStream.nextLine();
		Pattern patern = Pattern.compile("(O|M|X)([A-Z]{1})?([0-9][0-9])?");
		Matcher matcher = patern.matcher(input);

		
		if (matcher.matches()) {

			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		}
	}
}
