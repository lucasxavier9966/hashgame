package HashGame;

import java.nio.channels.AlreadyBoundException;
import java.util.*;

public class Hash {

	List<ArrayList<Integer>> Hash = new ArrayList<ArrayList<Integer>>();
	int winner = 0;

	public static void main(String[] args) {
		System.out.println("hello world");
	}

	public Hash(int lineHash) {
		if (lineHash >= 3 && lineHash <= 10) {
			for (int x = 0; x <= lineHash; x++) {
				ArrayList<Integer> line = new ArrayList<Integer>();
				this.Hash.add(line);
				for (int y = 0; y <= lineHash; y++) {
					line.add(0);
				}
			}
		}
	}

	public List<ArrayList<Integer>> nextPlay(int xPlay, int yPlay, int player) {
		try {
			int lineIndex = 0;
			int columnIndex = 0;
			for (ArrayList<Integer> line : this.Hash) {
				if (lineIndex == xPlay) {
					for (int column : line) {
						if (columnIndex == yPlay) {
							if (column == 0) {
								line.set(columnIndex, player);
								return this.checkWinner(xPlay, yPlay, player);
							} else {
								throw new AlreadyBoundException();
							}
						}
						columnIndex++;
					}
				}
				lineIndex++;
			}
		} catch (NullPointerException e) {
			System.out.println("erro: " + e);
		}
		return this.Hash;
	}

	public boolean verticalLine(int x, int player) {
		boolean winner = true;
		for (ArrayList<Integer> lineOfHash : this.Hash) {
			if (lineOfHash.get(x) != player) {
				winner = false;
			}
		}
		return winner;
	}

	public boolean horizontalLine(int x, int player) {
		boolean winner = true;
		ArrayList<Integer> linePlay = this.Hash.get(x);
		for (int column : linePlay) {
			if (column != player) {
				winner = false;
			}
		}
		return winner;
	}

	public boolean diagonalLines(int player) {
		boolean winner = true;
		int sizeHash = this.Hash.size() - 1;

		for (int yIndex = 0; yIndex <= sizeHash; yIndex++) {
			int diagonalInverse = sizeHash - yIndex;
			if (this.Hash.get(yIndex).get(diagonalInverse) != player) {
				winner = false;
			}
		}
		if (!winner) {
			for (int xIndex = 0; xIndex < sizeHash; xIndex++) {
				if (this.Hash.get(xIndex).get(xIndex) == player) {
					winner = true;
				}
			}
		}
		return winner;
	}

	public List<ArrayList<Integer>> checkWinner(int x, int y, int player) {

		boolean verticalLine = this.verticalLine(x, player);
		boolean horizontalLine = this.horizontalLine(x, player);
		boolean diagonalLines = this.diagonalLines(player);
		boolean winner = horizontalLine && verticalLine && diagonalLines;
		if (winner) {
			this.winner = player;
		}

		return this.Hash;
	}

}
