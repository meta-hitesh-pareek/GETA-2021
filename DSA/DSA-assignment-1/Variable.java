package GETA2021.DSA.DSAssignment1;

/**
 * Initialize a variable
 * 
 * @since 04-03-2021
 * @author Hitesh Pareek
 *
 */
public class Variable {
	int power;
	char variable;
	Variable next;

	/**
	 * Constructor to initialize variable
	 * 
	 * @param power
	 * @param variable
	 */
	Variable(int power, char variable) {
		this.power = power;
		this.variable = variable;
	}

	/**
	 * Return the power of the current variable
	 * 
	 * @return power
	 */
	public int getPower() {
		return this.power;
	}

	/**
	 * Return the variable character of the current variable
	 * 
	 * @return variable
	 */
	public char getVarible() {
		return this.variable;
	}
}
