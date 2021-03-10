package GETA2021.DSA.DSAAssignment3;

/**
 * Initialize the bowlers
 *
 * @since 10-03-2021
 * @author Hitesh Pareek
 */
public class Bowler {
	int id;
	int bowlsLeft;

	/**
	 * Initialize bowler's id and bowls left to bowl
	 * 
	 * @param id
	 * @param bowlsLeft
	 */
	Bowler(int id, int bowlsLeft) {
		if (bowlsLeft < 1) {
			throw new IllegalArgumentException();
		}

		this.id = id;
		this.bowlsLeft = bowlsLeft;
	}

	@Override
	public String toString() {
		return "Bowler [id=" + id + ", bowlsLeft=" + bowlsLeft + "]";
	}
}
