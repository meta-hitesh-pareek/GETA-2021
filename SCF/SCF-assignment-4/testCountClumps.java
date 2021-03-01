package assignment4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testCountClumps {

	ArrOperations test;

	@Before
	public void init() {
		test = new ArrOperations();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_When_arrayHasOneElement_Expected_0() {
		int arr[] = { 1 };
		int output = test.countClumps(arr);
		assertEquals(0, output);
	}

	@Test
	public void test_When_SizeGreaterThanOne_Expected_Integer() {
		int arr[] = { 1, 1, 2, 2, 1, 1 };
		int output = test.countClumps(arr);
		assertEquals(3, output);
	}

	@Test
	public void test_When_AllElementsAreSame_Expected_1() {
		int arr[] = { 1, 1, 1, 1, 1 };
		int output = test.countClumps(arr);
		assertEquals(1, output);
	}

	@Test
	public void negativeTestCaseForCountClumps() {
		int arr[] = { 1, 2, 3, 1, 1, 2 };
		int output = test.countClumps(arr);
		assertNotEquals(5, output);
	}
	
	@Test
	public void test_When_ArrayIsEmpty_Expected_AssertionErro()
	{
		try {
		int arr[]= {};
		int output=test.countClumps(arr);
		assertEquals(0, output);
		}catch(AssertionError e)
		{
			e.getMessage();
		}
	}

}
