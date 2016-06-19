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
 
    /**
     * Constructor.
     */
    private Minesweeper() {
        userInterface = new ConsoleUI();
        
        Field field = new Field(9, 9, 10);
        userInterface.newGameStarted(field);
        startMillis=System.currentTimeMillis();
    }
    /**
     * Get playing time 
     * @return int in seconds of playing
     */
    public int getPlayingSeconds(){
    	int currentTime= (int) (System.currentTimeMillis()-startMillis);
    	return currentTime;
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        new Minesweeper();

        
    }
}
