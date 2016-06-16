package minesweeper;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.Mine;

public class FieldTest {

	@Test
	public void testRowGetter() {
		Random rnd = new Random();
		int rows = rnd.nextInt(10) + 2;
		int cols = rnd.nextInt(10) + 2;
		int mines = rnd.nextInt(4) + 1;
		// System.out.println(rows+ " " + cols +" "+ mines );
		Field field = new Field(rows, cols, mines);
		assertEquals(rows, field.getRowCount());

	}

	@Test
	public void testCollGetter() {
		Random rnd = new Random();
		int rows = rnd.nextInt(10) + 2;
		int cols = rnd.nextInt(10) + 2;
		int mines = rnd.nextInt(4) + 1;
		// System.out.println(rows+ " " + cols +" "+ mines );
		Field field = new Field(rows, cols, mines);

		assertEquals(cols, field.getColumnCount());

	}

	@Test
	public void testMineGetter() {
		Random rnd = new Random();
		int rows = rnd.nextInt(10) + 2;
		int cols = rnd.nextInt(10) + 2;
		int mines = rnd.nextInt(4) + 1;
		System.out.println(rows + " " + cols + " " + mines);
		Field field = new Field(rows, cols, mines);

		assertEquals(mines, field.getMineCount());

	}

	@Test
	public void testFieldFilled() {
		Random rnd = new Random();
		int rows = rnd.nextInt(10) + 2;
		int cols = rnd.nextInt(10) + 2;
		int mines = rnd.nextInt(4) + 1;
		System.out.println(rows + " " + cols + " " + mines);
		Field field = new Field(rows, cols, mines);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				assertNotNull(field.getTile(i, j));
			}
		}
	}

	@Test
	public void generateMinesTest() {
		Random rnd = new Random();
		int rows = rnd.nextInt(10) + 2;
		int cols = rnd.nextInt(10) + 2;
		int mines = rnd.nextInt(4) + 1;
		System.out.println(rows + " " + cols + " " + mines);
		Field field = new Field(rows, cols, mines);
		int mineCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (field.getTile(i, j) instanceof Mine) {
					mineCount++;
				}
			}
		}

		assertEquals(mines, mineCount);
	}

	@Test
	public void generateClueTest() {
		Random rnd = new Random();
		int rows = rnd.nextInt(10) + 2;
		int cols = rnd.nextInt(10) + 2;
		int mines = rnd.nextInt(4) + 1;
		Field field = new Field(rows, cols, mines);
		int clueCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (field.getTile(i, j) instanceof Clue) {
					clueCount++;
				}
			}
		}
		assertEquals(rows * cols - mines, clueCount);
	}

	@Test
	public void isSolved() {
		
	}
}
