package GETA2021.DSA.DSAAssignment5;

/**
 * Define Node for ArrayList
 * 
 * @since 12-03-2021
 * @author Hitesh Pareek
 */
public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}