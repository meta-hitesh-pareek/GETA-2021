package GETA2021.SCF.SCFAssignment5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Cases for NQueen
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 */
public class TestCaseForNQueen {

	NQueenProblem nQueen;

	@Test
	public void test_WhenSizeIsOne_Expected_True() {

		int size = 1;
		nQueen = new NQueenProblem(size);

		boolean result = nQueen.findSolution(nQueen.board, 0);
		assertTrue(result);
	}

	@Test
	public void test_WhenSizeIsTwo_Expected_False() {
		int size = 2;
		nQueen = new NQueenProblem(size);

		boolean result = nQueen.findSolution(nQueen.board, 0);
		assertFalse(result);
	}

	@Test
	public void testForShowBoard() {
		int size = 4;
		nQueen = new NQueenProblem(size);
		int expectedArray[][] = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 },
				{ 0, 0, 0, 1 }, { 0, 1, 0, 0 } };

		nQueen.findSolution(nQueen.board, 0);
		assertArrayEquals(expectedArray, nQueen.board);
	}

}
