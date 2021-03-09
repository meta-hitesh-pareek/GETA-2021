package GETA2021.DSA.DSAAssignment2;

/**
 * Implements queue data structure
 * 
 * @since 08-03-2021
 * @author Hitesh Pareek
 *
 */
public class QueueImplement implements Queue {
	int rear = -1, front = -1;
	String queueArray[];

	/**
	 * Initialize queue size
	 * 
	 * @param size
	 */
	QueueImplement(int size) throws IllegalArgumentException {
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		queueArray = new String[size];
	}

	/**
	 * Add a value to the queue
	 * 
	 * @param value
	 * @return true if value added, else false
	 */
	public boolean add(String value) {
		if (front == -1 && rear == -1) {
			rear = 0;
			front = 0;
			queueArray[rear] = value;
			return true;
		} else if (rear < front && front - rear < 2) {
			return false;
		} else if (rear == queueArray.length - 1 && front != 0) {
			rear = 0;
			queueArray[rear] = value;
			return true;
		} else if (rear == queueArray.length - 1 && front == 0) {
			return false;
		} else {
			rear++;
			queueArray[rear] = value;
			return true;
		}
	}

	/**
	 * Removes value from the queue
	 * 
	 * @return true if value removed, else false
	 */
	public String remove() {
		if (rear == -1 && front == -1) {
			throw new NullPointerException();
		}
		if (rear == front) {
			String value = queueArray[front];
			rear = -1;
			front = -1;
			return value;
		}
		if (front == queueArray.length - 1) {
			String value = queueArray[front];
			front = 0;
			return value;
		} else {
			String value = queueArray[front];
			front++;
			return value;
		}
	}

	/**
	 * Checks if queue is empty or not
	 * 
	 * @return true id queue is empty, else return false
	 */
	public boolean isQueueEmpty() {
		if (rear == queueArray.length - 1 && front == 0) {
			return false;
		}
		if (rear < front && front - rear == 1) {
			return false;
		} else {
			return true;
		}
	}
}
