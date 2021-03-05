package GETA2021.DSA.DSAssignment1;

import java.util.InputMismatchException;

/**
 * Class to Visualize polynomial in nested list
 * 
 * @since 04-03-2021
 * @author Hitesh Pareek
 *
 */
public class PolynomialList {
	public Term head;

	/**
	 * Initializes new Polynomial list
	 * 
	 * @param coefficients
	 * @param variables
	 * @param powers
	 * @throws Exception
	 */
	public PolynomialList(int[] coefficients, char[][] variables, int[][] powers)throws Exception {
		if (coefficients == null || variables == null || powers == null) {
			throw new Exception("NullPointerException");
		}

		if (coefficients.length != variables.length
				|| variables.length != powers.length) {
			throw new Exception("Input mismatch");
		}

		int totalCoefficients = coefficients.length;
		Term currentTerm = null;

		for (int index = 0; index < totalCoefficients; index++) {/*We are adding all the coefficient and all terms
			                                                      to the List*/
			if (this.head == null) {
				this.head = new Term(coefficients[index]);
				currentTerm = head;
			} else {
				currentTerm = new Term(coefficients[index]);
				currentTerm.next = head;
				head = currentTerm;
			}

			if (variables[index] == null || powers[index] == null) {
				throw new NullPointerException();
			}

			if (variables[index].length != powers[index].length) {
				throw new InputMismatchException();
			}

			for (int variableIndex = 0; variableIndex < variables[index].length; variableIndex++) {
				currentTerm.addVariable(powers[index][variableIndex],
						variables[index][variableIndex]);
			}
		}
	}

	/**
	 * Finds the degree of the polynomial
	 * 
	 * @return degree
	 */
	public int findDegree() {
		int degree = 0;
		Term currentTerm = head;
		
		while (currentTerm != null) {
			degree = Math.max(degree, currentTerm.getPowerSum());
			currentTerm = currentTerm.next;
		}
		return degree;
	}
}
