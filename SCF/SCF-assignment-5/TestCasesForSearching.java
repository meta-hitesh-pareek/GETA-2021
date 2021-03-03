package GETA2021.SCF.SCFAssignment5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test methods of Searching Class
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class TestCasesForSearching {
	Searching search = new Searching();

	@Test
	public void test_ForLinearSearch_Expected_PositionOfValue() {
		int values[] = { 2, 3, 4, 5, 1, 3 };
		int position = search.LinearSearch(values, 0, 5, 4);

		assertEquals(2, position);
	}

	@Test
	public void test_ForLinearSearch_When_ArrayEmpty_Expected_AssertionError() {
		try {
			int values[] = {};
			int position = search.LinearSearch(values, 0, 0, 4);

			assertEquals(2, position);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void test_ForLinearSearch_WhenElementNotPresent_Expected_NegativeOne() {
		int values[] = { 2, 3, 4, 5, 1, 3 };
		int position = search.LinearSearch(values, 0, 5, 10);

		assertEquals(-1, position);
	}
	
	@Test
	public void test_ForSearch_Expected_PositionOfValue() {
		int values[] = { 1,2,4,5,6 };
		int position = search.BinarySearch(values, 0, 5, 4);

		assertEquals(2, position);
	}

	@Test
	public void test_ForBinarySearch_When_ArrayEmpty_Expected_AssertionError() {
		try {
			int values[] = {};
			int position = search.LinearSearch(values, 0, 0, 4);

			assertEquals(2, position);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}

	@Test
	public void test_ForBinarySearch_WhenElementNotPresent_Expected_NegativeOne() {
		int values[] = {1,2,4,6};
		int position = search.BinarySearch(values, 0, 3, 10);

		assertEquals(-1, position);
	}

}
