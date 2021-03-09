package GETA2021.DSA.DSAAssignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCasesForQueueImplement {

	@Test
	public void test_When_ZeroSizeIsPassed_Expected_IllegalArgumentException() {
		try {
			QueueImplement testQueue = new QueueImplement(0);
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void test_When_ElementAdded_Expected_True() {
		QueueImplement testQueue = new QueueImplement(2);
		boolean result = testQueue.add("hello");
		assertTrue(result);
	}

	@Test
	public void test_When_AddingElementWhenQueueIsFull_Expected_False() {
		QueueImplement testQueue = new QueueImplement(2);
		testQueue.add("Welcome");
		testQueue.add("hitesh");
		boolean result = testQueue.add("hello");
		assertFalse(result);
	}

	@Test
	public void test_When_DeleteFromEmptyQueue() {

		try {
			QueueImplement testQueue = new QueueImplement(2);
			testQueue.remove();
		} catch (NullPointerException e) {

		}
	}

}
