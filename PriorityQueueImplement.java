package GETA2021.DSA.DSAAssignment3;

import java.util.EmptyStackException;

/**
 * Implements function of a priority queue
 * 
 * @since 10-03-2021
 * @author Hitesh Pareek
 *
 */
public class PriorityQueueImplement implements PriorityQueue<Integer> {
	int rear, front;
	int queueElements[];

	/**
	 * Initialize priority queue
	 * 
	 * @param size
	 * @throws Exception
	 */
	PriorityQueueImplement(int size) throws Exception {
		if (size <= 0) {
			throw new NullQueueException("Queue is Empty");
		}

		queueElements = new int[size];
		rear = -1;
		front = -1;
	}

	/**
	 * Enters data to the queue
	 * 
	 * @param data
	 * @return true if the data is added, else false
	 */
	public boolean enqueue(Integer data) {
		if (front == -1 && rear == -1) {
			front = 0;
			rear = 0;
			queueElements[rear] = data;
			return true;
		}

		if (rear == queueElements.length - 1) {
			return false;
		} else {
			int position = rear;
			rear++;

			while (position >= 0 && queueElements[position] > data) {
				queueElements[position + 1] = queueElements[position];
				position--;
			}

			queueElements[position + 1] = data;
			return true;
		}
	}

	/**
	 * Remove the data from the queue
	 * 
	 * @return data which is removed
	 * @throws NullPointerException
	 */
	public Integer dequeue() {
		if (front == -1) {
			throw new NullPointerException();
		}
		
		if (front == 0 && rear == 0) {
			int data = queueElements[front];
			front = -1;
			rear = -1;
			return data;
		}
		
		if (front == queueElements.length - 1) {
			int data = queueElements[front];
			front = -1;
			rear = -1;
			
			return data;
		} else {
			int data = queueElements[front];
			front++;
			
			return data;
		}
	}

	/**
	 * Finds data at the front of the queue
	 * 
	 * @return data
	 */
	public Integer peek() {
		if (front == -1) {
			throw new EmptyStackException();
		} else {
			return queueElements[front];
		}
	}
}
