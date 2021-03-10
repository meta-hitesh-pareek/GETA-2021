package GETA2021.DSA.DSAAssignment3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 *Find Solution for the bowling order problem
 * 
 * @since 10-03-2021
 * @author Hitesh Pareek
 */
public class Bowling implements PriorityQueue<Bowler> {
	int capacity, size = 0;
	int rear, front;
	Bowler[] bowlersQueue;

	Bowling(int size) throws Exception {
		if (size <= 0) {
			throw new NullQueueException("Queue is Empty");
		}
		bowlersQueue = new Bowler[size];
		this.rear = -1;
		this.front = -1;
		capacity = size;
	}

	/**
	 * Push new bowler to the queue
	 * 
	 * @param bowler
	 * @return true if bowler added to queue, else false
	 */
	public boolean enqueue(Bowler bowler) {

		if (front == -1 && rear == -1) {
			front = 0;
			rear = 0;
			bowlersQueue[rear] = bowler;
			return true;
		}

		if (rear == bowlersQueue.length - 1) {
			return false;
		} else {
			int position = rear;
			rear++;
			while (position >= 0
					&& bowlersQueue[position].bowlsLeft < bowler.bowlsLeft) {
				bowlersQueue[position + 1] = bowlersQueue[position];
				position--;
			}
			bowlersQueue[position + 1] = bowler;
			
		}
		size++;
		return true;
	}

	/**
	 * Removes a bowler from the queue
	 * 
	 */
	public Bowler dequeue() {
		int position = 0;
		Bowler bowler = null;
		bowler = bowlersQueue[position];
		while (position < rear) {
			bowlersQueue[position] = bowlersQueue[position + 1];
			position++;
		}
		size--;
		return bowler;
	}

	/**
	 * Find the bowler in the front of the queue
	 * 
	 * @return bowler
	 */
	public Bowler peek() {
		if (front == -1) {
			throw new EmptyStackException();
		} else {
			return bowlersQueue[front];
		}
	}

	/**
	 * Finds the order of bowlers to bowl
	 *
	 * @param totalBowls
	 * @return list of bowlers
	 */
	public List<Bowler> bowlersOrder(int totalBowls) {
		List<Bowler> order = new ArrayList<Bowler>();
		while (totalBowls > 0) {
			Bowler currentBowler = dequeue();
			order.add(currentBowler);
			if (currentBowler != null) {
				if (currentBowler.bowlsLeft > 0) {
					int temp = currentBowler.bowlsLeft;
					if (peek().bowlsLeft > 0) {
						currentBowler.bowlsLeft = peek().bowlsLeft - 1;
					} else {
						currentBowler.bowlsLeft = 0;
					}
					totalBowls = totalBowls - (temp - currentBowler.bowlsLeft);
				}
				if (currentBowler.bowlsLeft > 0) {
					enqueue(currentBowler);
				} else {
					break;
				}
			}
		}
		return order;
	}
	public static void main(String args[]) throws Exception {
		Bowling testBowling =new Bowling(4);
		Bowler bowler1 =new Bowler(1,7);
		Bowler bowler2 =new Bowler(2,6);
		Bowler bowler3 =new Bowler(3,2);
		Bowler bowler4 =new Bowler(4,1);
		List<Bowler> bowlersList=testBowling.bowlersOrder(6);
		for(int index=0;index<bowlersList.size()-1;index++) {
			System.out.println(bowlersList.get(index).bowlsLeft);
		}
	}
}
