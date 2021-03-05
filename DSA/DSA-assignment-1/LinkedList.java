package GETA2021.DSA.DSAssignment1;

/**
 * Implements Linked List data structure
 * 
 * @since 04-03-2021
 * @author Hitesh Pareek
 *
 */
public class LinkedList {
	Node head;

	/**
	 * Initialize a new node for linked list
	 * 
	 * @since 04-04-2021
	 * @author Hitesh Pareek
	 *
	 */
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * Adds a node at the end of linked list
	 * 
	 * @param data
	 */
	public void addLast(int data) {
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
	}

	/**
	 * Finds the size of given Linked List
	 * 
	 * @param head
	 * @return size of list
	 */
	public int size(Node head) {
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

	/**
	 * Rotates the given sublist of a list clockwise
	 * 
	 * @param L ,the first index of sublist
	 * @param R ,the last index of sublist
	 * @param N ,number of times to be rotated
	 */
	public Node rotateRight(int L, int R, int N) {
		int size = this.size(head);
		Node currentNode = head;
		Node prev = null;
		int count = 1;
		
		if (L > R) {
			throw new IllegalArgumentException();
		}
		
		if (size < R) {
			throw new AssertionError("List too small");
		}
		
		if (L >= 1 && L < R && L < size && R <= size) {
			while (count < L) {
				prev = currentNode;
				currentNode = currentNode.next;
				count++;
			}
			
			Node leftNode = currentNode;
			int subListSize = R - L + 1;
			if (N > subListSize) {
				N %= subListSize;  //If N is greater than sublist size it will be rotated by (N%subListSize) times
			} else if (N == subListSize) {
				return head;
			}
			
			Node temp = null;
			while (N < subListSize) {
				subListSize--;
				temp = currentNode;
				currentNode = currentNode.next;
			}

			if (prev != null) {
				prev.next = currentNode;
			} else {
				head = currentNode;
			}
			
			while (subListSize - 1 > 0) {
				subListSize--;
				currentNode = currentNode.next;
			}
			
			if (temp != null && currentNode != null) {
				temp.next = currentNode.next;
				currentNode.next = leftNode;
			}
		}
		return head;
	}

	/**
	 * Checks if the given Linked List contains a loop
	 * 
	 * @param head
	 * @return true if it contains loop, else false
	 */
	public boolean checkLoop(Node head) {
		if (head == null) {
			throw new AssertionError("List is empty");
		}
		Node slow = head, fast = head;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { //When slow and fast are at same address we can know that they followed a loop
				return true;
			}
		}
		return false;
	}
}
