package assignment4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testSplitArray {

	ArrOperations test = new ArrOperations();

	@Before
	public void init() {
		test = new ArrOperations();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_When_SingleElementInArray_Expected_NegativeOne() {
		int arr[] = { 1 };
		int output = test.splitArray(arr);
		assertEquals(-1, output);
	}

	@Test
	public void test_When_GreaterThanOneElement_Expected_Integer() {
		int arr[] = { 1, 2, 3, 6 };
		int output = test.splitArray(arr);
		assertEquals(3, output);
	}

	@Test
	public void test_When_ArrayCannotBeSplitted_Expected_NegativeOne() {
		int arr[] = { 1, 2, 2, 4 };
		int output = test.splitArray(arr);
		assertEquals(-1, output);
	}

	@Test
	public void negatceTestForSplitArray() {
		int arr[] = { 1, 2, 3, 6 };
		assertFalse(1 == test.splitArray(arr));
	}

}
