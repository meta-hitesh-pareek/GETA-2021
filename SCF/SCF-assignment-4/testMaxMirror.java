package assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testMaxMirror {

	ArrOperations test;

	@Before
	public void init() {
		test = new ArrOperations();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_When_ArraySizeGreaterThanOne_Integer() {
		int arr[] = { 1, 2, 3, 4, 6, 3, 2, 1 };
		int output = test.maxMirror(arr);
		assertEquals(3, output);
	}

	@Test
	public void test_When_WholeArrayIsMirror() {
		int arr[] = { 1, 2, 3, 4, 3, 2, 1 };
		int output = test.maxMirror(arr);
		assertEquals(7, output);
	}

	@Test
	public void test_When_ArrayHasSinlgeElement_Expected_1() {
		int arr[] = { 2 };
		int output = test.maxMirror(arr);
		assertEquals(1, output);
	}
}
