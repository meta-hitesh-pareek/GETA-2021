package GETA2021.DSA.DSAAssignment2;

import org.apache.*;

/**
 * Evaluate Infix expression
 * 
 * @since 08-03-2021
 * @author Hitesh Pareek
 *
 */
public class InfixEvaluation {
	String expression;
	
	public InfixEvaluation(String expression) throws NullPointerException {
		if(expression==null) {
			throw new NullPointerException();
		}
		if("".equals(expression)) {
			throw new IllegalArgumentException();
		}
		this.expression=expression;
	}
	
	/**
	 * Checks if given operator is Arithmetic or not
	 * 
	 * @param operator
	 * @return true if it is arithmetic operator else, return false
	 */
	public static boolean isArithmeticOperator(String operator) {
		if (operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("/")) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if given operator is Boolean Operator or not
	 * 
	 * @param operator
	 * @return true if it is arithmetic operator else, return false
	 */
	public static boolean isBooleanOperator(String operator) {
		if (operator.equals("==") || operator.equals("!=")
				|| operator.equals("<=") || operator.equals(">=")
				|| operator.equals("&&") || operator.equals("||")
				|| operator.equals("<") || operator.equals(">")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if given value is operand or not
	 * 
	 * @param value
	 * @return true if it is an operand else, return false
	 */
	public static boolean isOpearand(String value) {
		int index = 0;
		while (index < value.length()) {
			char character = value.charAt(index);
			if (character >= '0' && character <= '9') {
				index++;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return the precedence of the given operator the higher the value the more
	 * the precedence is
	 * 
	 * @param operator
	 * @return the precedence
	 */
	public static int precedence(String operator) {
		//The higher the precedence is the higher value it will return
		if (operator.equals("*") || operator.equals("/")) {
			return 6;
		}
		if (operator.equals("+") || operator.equals("-")) {
			return 5;
		}
		if (operator.equals("<") || operator.equals(">")
				|| operator.equals(">=") || operator.equals("<=")) {
			return 4;
		}
		if (operator.equals("==") || operator.equals("!=")) {
			return 3;
		}
		if (operator.equals("&&")) {
			return 2;
		}
		if (operator.equals("||")) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Solves the arithmetic expression
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @param operator
	 * @return result of the arithmetic operation
	 */
	public static String solveArithmatic(String firstOperand,
			String secondOperand, String operator) {

		if (!firstOperand.equals("true") || !firstOperand.equals("false")
				&& !secondOperand.equals("true")
				|| !secondOperand.equals("false")) {
			int operand1 = Integer.parseInt(firstOperand);
			int operand2 = Integer.parseInt(secondOperand);

			if (operator.equals("/")) {
				return String.valueOf(operand1 / operand2);
			} else if (operator.equals("*")) {
				return String.valueOf(operand1 * operand2);
			} else if (operator.equals("-")) {
				return String.valueOf(operand1 - operand2);
			} else {
				return String.valueOf(operand1 + operand2);
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Solve operation which gives boolean result
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @param operator
	 * @return boolean result in String format
	 * @throws Exception
	 */
	public static String solveBoolean(String firstOperand,
			String secondOperand, String operator) throws Exception {
		if (firstOperand.equals("true") || firstOperand.equals("false")
				&& secondOperand.equals("true")
				|| secondOperand.equals("false")) {
			if (operator.equals("||")) {
				return String.valueOf(Boolean.valueOf(firstOperand)
						|| Boolean.valueOf(secondOperand));
			} else if (operator.equals("&&")) {
				return String.valueOf(Boolean.valueOf(firstOperand)
						&& Boolean.valueOf(secondOperand));
			}
		} else {
			if (operator.equals("<")) {
				return String.valueOf(Integer.parseInt(firstOperand) < Integer
						.parseInt(secondOperand));
			} else if (operator.equals(">")) {
				return String.valueOf(Integer.parseInt(firstOperand) > Integer
						.parseInt(secondOperand));
			} else if (operator.equals("==")) {
				return String.valueOf(Integer.parseInt(firstOperand) == Integer
						.parseInt(secondOperand));
			} else if (operator.equals("<=")) {
				return String.valueOf(Integer.parseInt(firstOperand) <= Integer
						.parseInt(secondOperand));
			} else if (operator.equals(">=")) {
				return String.valueOf(Integer.parseInt(firstOperand) >= Integer
						.parseInt(secondOperand));
			} else if (operator.equals("!=")) {
				return String.valueOf(Integer.parseInt(firstOperand) != Integer
						.parseInt(secondOperand));
			} else {
				throw new UnsupportedOperationException();
			}
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Solves the given infix expression
	 * 
	 * @param expression
	 * @return the output of the expression as a String
	 * @throws Exception
	 */
	public String SolveInfix(String expression) throws Exception {

		StackImplement operandStack = new StackImplement();
		StackImplement operatorStack = new StackImplement();

		int index = 0;

		while (index < expression.length()) {
			String term = "";

			while (index < expression.length()
					&& expression.charAt(index) != ' ') {
				term += expression.charAt(index++);

			}
			if (isBooleanOperator(term)) { // Checking is current term is a
											// boolean operator or not
				while (operatorStack.size() > 0) {
					if (isArithmeticOperator(operatorStack.top())
							&& (precedence(operatorStack.top()) >= precedence(term))) {
						String firstOperand = operandStack.pop();
						String secondOperand = operandStack.pop();
						String operator = operatorStack.pop();
						String result;

						if (isBooleanOperator(operator)) {
							result = solveBoolean(secondOperand, firstOperand,
									operator);

						} else {
							result = solveArithmatic(secondOperand,
									firstOperand, operator);
						}
						operandStack.push(result);
					} else {
						break;
					}
				}
				operatorStack.push(term);
			} else if (isArithmeticOperator(term)) {
				// check if the current term is a arithmetic operator or not

				while (operatorStack.size() > 0) {
					if (!isBooleanOperator(operatorStack.top())
							&& (precedence(operatorStack.top()) >= precedence(term))) {

						String firstOperand = operandStack.pop();
						String secondOperand = operandStack.pop();
						String operator = operatorStack.pop();
						String result;
						result = solveArithmatic(secondOperand, firstOperand,
								operator);

						operandStack.push(result);

					} else {
						break;
					}
				}
				operatorStack.push(term);
			} else if (isOpearand(term)) {
				operandStack.push(term);
			} else if (term.equals("(")) {
				operatorStack.push(term);
			} else if (term.equals(")")) {
				//When we find ")" we will evaluate till we find "(" or the stack is empty
				while (operandStack.size() > 0
						&& (operatorStack.top().charAt(0) != '(')) {
					String firstOperand = operandStack.pop();
					String secondOperand = operandStack.pop();
					String operator = operatorStack.pop();
					String result;

					if (isBooleanOperator(operator)) {
						result = solveBoolean(secondOperand, firstOperand,
								operator);
						operandStack.push(result);

					} else if (isArithmeticOperator(operator)) {
						result = solveArithmatic(secondOperand, firstOperand,
								operator);
						operandStack.push(result);
					}

				}
				operatorStack.pop();
			} else {
				throw new UnsupportedOperationException();
			}
			index++;
		}
		
		//When there are operators an operand left we will evaluate them
		while (operatorStack.size() > 0) {
			String operator = operatorStack.pop();
			String firstOperand = operandStack.pop();
			String secondOperand = operandStack.pop();

			String result;

			if (isBooleanOperator(operator)) {
				result = solveBoolean(secondOperand, firstOperand, operator);

			} else {
				result = solveArithmatic(secondOperand, firstOperand, operator);
			}
			operandStack.push(result);

		}
		return operandStack.pop();
	}
	public static void main(String args[]) throws Exception {
		String s="2 + 5";
		InfixEvaluation in =new InfixEvaluation(s);
		System.out.println(in.SolveInfix(s));
	}
}