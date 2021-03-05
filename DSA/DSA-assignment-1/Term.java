package GETA2021.DSA.DSAssignment1;

/**
 * Class to create term for the polynomial
 * 
 * @since 04-03-2021
 * @author Hitesh Pareek
 *
 */
public class Term {
	public int coefficients;
	public Variable variables;
	public Term next;

	/**
	 * Adds coefficient
	 * 
	 * @param coefficient
	 */
	public Term(int coefficient) {
		this.coefficients = coefficient;
	}

	/**
	 * get coefficient of the current term
	 * 
	 * @return
	 */
	public int getCoefficients() {
		return this.coefficients;
	}

	/**
	 * Gets the variable of the current term
	 * 
	 * @return Variable
	 */
	public Variable gerVariable() {
		return this.variables;
	}

	/**
	 * Add variable to the current term
	 * 
	 * @param power
	 * @param variable
	 */
	public void addVariable(int power, char variable) {
		if (this.variables == null) {
			this.variables = new Variable(power, variable);
			return;
		}
		Variable currentVariable = new Variable(power, variable);
		currentVariable.next = this.variables;
		this.variables = currentVariable;
	}

	/**
	 * Find sum of the powers of given term of all variable of term
	 * 
	 * @return sum of powers
	 */
	public int getPowerSum() {
		int powerSum = 0;
		Variable currentVaribale = this.variables;
		while (currentVaribale != null) {
			powerSum += currentVaribale.getPower();
			currentVaribale = currentVaribale.next;
		}
		return powerSum;
	}
}
