package GETA2021.DSA.DSAAssignment2;

import java.util.EmptyStackException;

public class StackImplement implements Stack {
	Node head;

	/**
	 * Initialize a new node for linked list
	 * 
	 * @since 04-04-2021
	 * @author Hitesh Pareek
	 *
	 */
	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * Adds a node at the top of the stack
	 * 
	 * @param data
	 */
	@Override
	public boolean push(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return true;
	}

	public String pop() {
		if (head == null) {
			throw new EmptyStackException();
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.next != null) {
				temp = temp.next;
			}
			if(temp.next==null) {
				String value=temp.data;
				head=null;
				return value;
			}else {
			String value = temp.next.data;
			temp.next = null;
			return value;
			}
		}
	}

	/**
	 * Return the top element of the stack
	 * 
	 * @return value
	 */
	public String top() {
		if (head == null) {
			throw new EmptyStackException();
		} else {
			Node temp = head;
			while (temp.next!=null) {
				temp = temp.next;
			}
			
			String value = temp.data;
			return value;
		}
	}

	/**
	 * Finds the size of given Linked List
	 * 
	 * @param head
	 * @return size of list
	 */
	public int size() {
		Node temp = this.head;
		int countNode = 0;
		if (head == null) {
			return 0;
		}
		while (temp != null) {
			countNode++;
			temp = temp.next;
		}
		return countNode;
	}

	/**
	 * Prints the Linked List
	 */
	public void printNode() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "-->");
				temp = temp.next;
			}
		}
	}
}
