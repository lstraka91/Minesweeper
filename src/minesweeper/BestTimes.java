package minesweeper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/**
 * Player times.
 */
public class BestTimes implements Iterable<BestTimes.PlayerTime> {
	/** List of best player times. */
	private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();

	/**
	 * Returns an iterator over a set of best times.
	 * 
	 * @return an iterator
	 */
	public Iterator<PlayerTime> iterator() {
		return playerTimes.iterator();
	}

	/**
	 * Adds player time to best times.
	 * 
	 * @param name
	 *            name to the player
	 * @param time
	 *            player time in seconds
	 */
	public void addPlayerTime(String name, int time) {
		playerTimes.add(new PlayerTime(name, time));
		Collections.sort(playerTimes);
	}
	
	public void reset(){
		playerTimes.removeAll(playerTimes);
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return a string representation of the object
	 */
	public String toString() {
		
		Formatter f = new Formatter();
		int index = 1;
		for (PlayerTime playerTime : playerTimes) {
			f.format("%d. %s  %d\t \n", index, playerTime.getName(), playerTime.getTime());
			index++;
		}

		return f.toString();
	}

	/**
	 * Player time.
	 */
	public static class PlayerTime implements Comparable<PlayerTime> {
		/** Player name. */
		private final String name;

		public String getName() {
			return name;
		}

		public int getTime() {
			return time;
		}

		/** Playing time in seconds. */
		private final int time;

		/**
		 * Constructor.
		 * 
		 * @param name
		 *            player name
		 * @param time
		 *            playing game time in seconds
		 */
		public PlayerTime(String name, int time) {
			this.name = name;
			this.time = time;
		}

		@Override
		public int compareTo(PlayerTime o) {
			if (getTime() > o.getTime()) {
				return -1;
			} else if (getTime() < o.getTime()) {
				return 1;
			}
			return 0;
		}
	}
}