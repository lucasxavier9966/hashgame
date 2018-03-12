package HashGame;

import java.util.ArrayList;
import java.util.List;
import hash.hash;
import junit.framework.*;

public class TestHash extends TestCase {

	double saldoAtual = 2000.00;
	int numeroAgencia = 000000;
	int numeroConta = 000000;

	private Hash hash = new Hash(3);

	public static void main() {

	}

	public void testNextPlay() {
		Hash hash = this.hash;
		List<ArrayList<Integer>> matrix = hash.nextPlay(3, 3, 1);
		if (hash.winner != 0) {
			assertEquals(1, hash.winner);
		}
	}

	public void testHorizontalLineIntegrated() {
		Hash hash = this.hash;
		List<ArrayList<Integer>> matrix = hash.nextPlay(3, 3, 1);
		matrix = hash.nextPlay(3, 2, 1);
		matrix = hash.nextPlay(3, 1, 1);
		matrix = hash.nextPlay(3, 0, 1);
		assertEquals(true, hash.horizontalLine(3, 1));
	}

	public void testVerticalLines() {
		Hash hash = this.hash;
		List<ArrayList<Integer>> matrix = hash.nextPlay(0, 3, 1);
		matrix = hash.nextPlay(1, 3, 1);
		matrix = hash.nextPlay(2, 3, 1);
		matrix = hash.nextPlay(3, 3, 1);
		assertEquals(true, hash.verticalLine(3, 1));
	}

	public void testDiagonalLines() {
		Hash hash = this.hash;
		List<ArrayList<Integer>> matrix = hash.nextPlay(3, 0, 1);
		matrix = hash.nextPlay(2, 1, 1);
		matrix = hash.nextPlay(1, 2, 1);
		matrix = hash.nextPlay(0, 3, 1);
		System.out.println(matrix);
		assertEquals(true, hash.diagonalLines(1));
	}

	public void testHorizontalLine() {
		Hash hash = this.hash;
		boolean winner = hash.horizontalLine(1, 0);
		assertEquals(true, winner);
	}

	public void testVerticalLine() {
		Hash hash = this.hash;
		boolean winner = hash.verticalLine(1, 0);
		assertEquals(true, winner);
	}
}
