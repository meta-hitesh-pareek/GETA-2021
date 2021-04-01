package GETA2021.DSA.DSAAssignment3;

/**
 * Declares function to be defined for Priority Queue
 * 
 * @since 10-03-2021
 * @author Hitesh Pareek
 *
 * @param <T>, generic data type
 */
public interface PriorityQueue<T> {

	public boolean enqueue(T data);

	public T peek();

	public T dequeue();

}
