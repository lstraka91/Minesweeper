package minesweeper;

import java.io.Serializable;

public class Settings implements Serializable {

	private final int rowCount;
	private final int columnCount;
	private final int mineCount;
	public static final Settings BEGGINER = new Settings(9, 9, 10);
	public static final Settings INTERMEDIATE = new Settings(16, 16, 40);
	public static final Settings EXPERT = new Settings(16, 30, 99);
	private static final String SETTING_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + "minesweeper.settings";

	public Settings(int rowCount, int columnCount, int mineCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.mineCount = mineCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getMineCount() {
		return mineCount;
	}
	@Override
	public boolean equals(Object o){
		//not implemented yet
		return false;
		
	}

}
