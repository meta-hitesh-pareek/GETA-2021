package GETA2021.DSA.DSAssignment1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests methods of Polynomial List
 * 
 * @since 04-03-2021
 * @author Hitesh Pareek
 */
public class TestCasesForPoynomialList {

	@Test
	public void test_When_CorrectArgumentPasses_Expected_Integer()throws Exception {
		int[] coefficients = { 1, 2 };
		char[][] variable = { { 'x', 'y' }, { 'x', 'y' } };
		int[][] powers = { { 1, 2 }, { 2, 6 } };
		
		PolynomialList list = new PolynomialList(coefficients, variable, powers);
		int degree = list.findDegree();
		assertEquals(8, degree);
	}

	@Test
	public void test_When_WrongArgumentPasses_Expected_Exception() {

		int[] coefficients = { 1 };
		char[][] variable = { { 'x', 'y' }, { 'x', 'y' } };
		int[][] powers = { { 1, 2 }, { 2, 6 } };
		
		try {
			PolynomialList list = new PolynomialList(coefficients, variable,powers);
			int degree = list.findDegree();
			assertEquals(8, degree);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
