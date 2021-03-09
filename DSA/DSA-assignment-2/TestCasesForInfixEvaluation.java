package GETA2021.DSA.DSAAssignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * Test methods for InfixEvaluation
 * 
 * @since 07-03-2021
 * @author Hitesh Pareek
 */
public class TestCasesForInfixEvaluation {

	@Test
	public void test_When_ValidStringPasses_Expected_Integer() throws Exception {
		String expression = "( 2 + 5 )";
		InfixEvaluation infixResult = new InfixEvaluation(expression);

		assertEquals("7", infixResult.SolveInfix(expression));
	}

	@Test
	public void test_When_InvalidStringPasses_Expected_UnsupportedOperationException()
			throws Exception {
		try {
			String expression = "(32+3)";
			InfixEvaluation infixResult = new InfixEvaluation(expression);

			assertEquals("35", infixResult.SolveInfix(expression));
		} catch (UnsupportedOperationException e) {
			e.getMessage();
		}
	}

	@Test
	public void test_When_NullIsPases_Expected_NullPointerException() {
		try {
			InfixEvaluation infixReult = new InfixEvaluation(null);
		} catch (NullPointerException e) {
			e.getMessage();
		}
	}

	@Test
	public void test_When_EmptyStringPasses_Expected_IllegalArgumentException() {
		try {
			InfixEvaluation infixReult = new InfixEvaluation("");
		} catch (IllegalArgumentException e) {
			e.getMessage();
		}
	}

	@Test
	public void test_When_BooleanOperatorPasses_Expected_BooleanResult()
			throws Exception {
		String expression = "( 2 != 5 )";
		InfixEvaluation infixResult = new InfixEvaluation(expression);

		assertEquals("true", infixResult.SolveInfix(expression));
	}
}
