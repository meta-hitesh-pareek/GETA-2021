package GETA2021.DSA.DSAssignment1;

import static org.junit.Assert.*;

import org.junit.Test;

import GETA2021.DSA.DSAssignment1.LinkedList.Node;

/**
 * Test methods of LinkedList class
 * 
 * @since 04-03-2021
 * @author Hitesh Pareek
 */
public class TestCasesForLinkedList {

	@Test
	public void test_WhenSizeOfListIsZero_Expected_0() {
		LinkedList list = new LinkedList();

		int actual = list.size(list.head);
		assertEquals(0, actual);
	}

	@Test
	public void test_WhenSizeOfListGreaterThanZero_Expected_Integer() {
		LinkedList list = new LinkedList();

		list.addLast(2);
		list.addLast(4);
		list.addLast(6);
		int actual = list.size(list.head);
		assertEquals(3, actual);
	}

	@Test
	public void test_ForRotatingSubList_Expected_RotatedSubList() {
		LinkedList list = new LinkedList();
		LinkedList testList = new LinkedList();
		testList.addLast(2);
		testList.addLast(6);
		testList.addLast(4);
		list.addLast(2);
		list.addLast(4);
		list.addLast(6);

		list.head = list.rotateRight(2, 3, 1);
		Node testListTemp = testList.head;
		Node listTemp = list.head;
		int size = testList.size(testList.head);
		for (int index = 0; index < size; index++) {
			assertEquals(testListTemp.data, listTemp.data);
			listTemp = listTemp.next;
			testListTemp = testListTemp.next;
		}
	}

	@Test
	public void test_ForRotatingSubList_When_SizeLessThanRightIndex_Expected_Error() {
		LinkedList list = new LinkedList();
		list.addLast(2);
		list.addLast(4);
		list.addLast(6);
		try {
			list.head = list.rotateRight(2, 3, 1);
		} catch (AssertionError e) {
			e.getMessage();
		}
	}
}
