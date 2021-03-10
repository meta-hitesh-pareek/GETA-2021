package GETA2021.DSA.DSAAssignment3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *Tests methods of PriorityQueueImplement
 *
 * @since 10-03-2021
 * @author Hitesh Pareek
 */
public class TestsForPriorityQueueImplement {

	@Test
	public void test_When_SizePassedIsZero_Expected_NullQueueException()
			throws Exception {
		try {
			PriorityQueueImplement testQueue = new PriorityQueueImplement(0);
		} catch (NullQueueException e) {
			e.getMessage();
		}
	}

	@Test
	public void test_When_ElementIsAdded_Expected_True() throws Exception {
		PriorityQueueImplement testQueue = new PriorityQueueImplement(2);
		boolean result = testQueue.enqueue(4);
		
		assertTrue(result);
	}
	
	@Test
	public void test_When_ElementIsRemoved_Expected_Integer() throws Exception {
		PriorityQueueImplement testQueue = new PriorityQueueImplement(2);
		testQueue.enqueue(4);
		int result=testQueue.dequeue();
		assertEquals(4, result);
	}
	
	@Test
	public void test_When_ElementRemovedFromEmptyQueue_Expected_NullPointerException() throws Exception {
		try {
		PriorityQueueImplement testQueue = new PriorityQueueImplement(2);
		testQueue.dequeue();
		}catch(NullPointerException e) {
			e.getMessage();
		}
	}
}
