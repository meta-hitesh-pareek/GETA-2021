package GETA2021.DSA.DSAAssignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Contains method to find molecular mass
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class MassCalculator {
	static final Map<Character, Integer> molecularMass = new HashMap<Character, Integer>();
	Stack<Character> elementStack = new Stack<>();

	/**
	 * Calculates the molecular mass of given formulae
	 * 
	 * @param element
	 * @return molecular mass
	 */
	public int calulateMass(String element) {
		molecularMass.put('C', 12);
		molecularMass.put('O', 16);
		molecularMass.put('H', 1);

		int totalMass = 0;
		for (int index = 0; index < element.length(); index++) {
			elementStack.push(element.charAt(index));
		}

		// bracketOpen is to check that bracket is open or not in the formulae
		boolean bracketOpen = false;
		int digit = -1;// digit to define number of atom like in H2 its 2
		int bracketDigit = -1;

		/*
		 * Popping out every element from the stack and addingthe molecular mass
		 * of each element popped
		 */
		while (elementStack.size() > 0) {
			char poppedElement = elementStack.pop();

			if (Character.isDigit(poppedElement)) {
				if (digit == -1) {
					digit = Integer.parseInt(String.valueOf(poppedElement));
				} else {
					digit = (digit * 10)
							+ Integer.parseInt(String.valueOf(poppedElement));
				}

				/*
				 * If bracket is open the mass inside the brackets will be
				 * multiplied by the digit outside bracket
				 */
				if (bracketDigit != -1 && bracketOpen) {
					digit *= bracketDigit;
				}
			} else if (poppedElement == 'C' || poppedElement == 'O'
					|| poppedElement == 'H') {
				if (digit == -1) {
					if (bracketOpen) {
						totalMass += bracketDigit
								* molecularMass.get(poppedElement);
					} else {
						totalMass += molecularMass.get(poppedElement);
					}
				} else {
					totalMass += digit * (molecularMass.get(poppedElement));
					digit = -1;
				}
			} else if (poppedElement == ')') {
				bracketOpen = true;
				if (digit != -1) {
					bracketDigit = digit;
					digit = -1;
				}
			} else if (poppedElement == '(') {
				if(bracketOpen==false) {
					throw new IllegalArgumentException();
				}
				bracketDigit = -1;
				bracketOpen = false;
			} else {
				throw new IllegalArgumentException("Wrong element");
			}
		}
		// If the all brackets are not closed the formulae will me invalid
		if (bracketOpen) {
			throw new IllegalArgumentException("Check parantheses");
		}

		return totalMass;
	}
}
