package GETA2021.DSA.DSAAssignment6;

import GETA2021.DSA.DSAAssignment5.*;

/**
 * Sort the employee according to their Salary
 * 
 * @since 14-03-2021
 * @author Hitesh Pareek
 */
public class QuickSort {

	/**
	 * Partition the list in two parts after sorting one element to its correct
	 * position
	 * 
	 * @param head
	 * @param end
	 * @return position of the sorted element
	 */
	Node<Employee> partionList(Node<Employee> head, Node<Employee> end) {
		if (head == end || head == null || end == null) {
			return head;
		}

		Node<Employee> lastPivot = head;
		Node<Employee> current = head;
		Employee pivot = end.data;
		Employee swapVariable;

		while (head != end) {
			if (head.data.salary < pivot.salary
					|| (head.data.salary < pivot.salary && head.data.age < pivot.age)) {
				lastPivot = current;
				swapVariable = current.data;
				current.data = head.data;
				head.data = swapVariable;
				current = current.next;
			}
			head = head.next;
		}

		swapVariable = current.data;
		current.data = pivot;
		end.data = swapVariable;

		return lastPivot;
	}

	/**
	 * Sort the list of employees according to salary
	 * 
	 * @param start
	 * @param end
	 */
	public void sort(Node<Employee> start, Node<Employee> end) {
		if(start==null || end==null) {
			throw new NullPointerException("Null reference of node are passed");
		}
		if (start == end) {
			return;
		}
		Node<Employee> lastPivot = partionList(start, end);
		sort(start, lastPivot);

		if (lastPivot != null && lastPivot == start) {
			sort(lastPivot.next, end);
		}

		else if (lastPivot != null && lastPivot.next != null) {
			sort(lastPivot.next.next, end);
		}
	}
}