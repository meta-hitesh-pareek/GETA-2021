package GETA2021.DSA.DSAAssignment6;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

/**
 * Test methods of Graph
 * 
 * @since 14-03-2021
 * @author Hitesh Pareek
 */
public class TestsForGraph {

	@Test
	public void test_When_NullIsPassedInIsReachable_Expected_NullPointerException() {
		try {
			Graph test = new Graph();
			test.isReachable(null, 1);
		} catch (NullPointerException exception) {
			exception.getMessage();
		}
	}

	@Test
	public void test_When_NullIsPassedInIsConnected_Expected_NullPointerException() {
		try {
			Graph test = new Graph();
			test.isConnected(null);
		} catch (NullPointerException exception) {
			exception.getMessage();
		}
	}

	@Test
	public void test_When_NullIsPassedInFindMST_Expected_NullPointerException() {
		try {
			Graph test = new Graph();
			test.findMST(null);
		} catch (NullPointerException exception) {
			exception.getMessage();
		}
	}

	@Test
	public void test_When_NullIsPassedInFindShortestPath_Expected_NullPointerException() {
		try {
			Graph test = new Graph();
			test.findShortestPath(null, 1, 2);
		} catch (NullPointerException exception) {
			exception.getMessage();
		}
	}

	@Test
	public void test_When_ValidArgumentPassedInIsConnected_Expected_Boolean() {
		int[][] graph = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
		Graph test = new Graph();

		assertTrue(test.isConnected(graph));
	}

	@Test
	public void test_When_ValidArgumentPassedInIsReachable_Expected_Integer() {
		int[][] graph = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
		Graph test = new Graph();
		LinkedList<Integer> testList = new LinkedList<Integer>();

		testList = (LinkedList<Integer>) test.isReachable(graph, 1);
		assertEquals(1, testList.remove().intValue());
	}
}
