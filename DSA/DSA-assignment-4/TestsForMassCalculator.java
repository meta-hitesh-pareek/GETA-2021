package GETA2021.DSA.DSAAssignment4;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test method of MassCalculator
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class TestsForMassCalculator {

	@Test
	public void test_When_WrongElementIsPassed_Expected_IllegalArgumentException() {
		MassCalculator test =new MassCalculator();
		String formulae="CKOOC3";
		try {
			assertEquals(20,test.calulateMass(formulae) );
		}catch(IllegalArgumentException exception) {
			
		}
	}
	
	@Test
	public void test_When_BracketsNotClosed_Expected_IllegalArgumentException() {
		MassCalculator test =new MassCalculator();
		String formulae="CH3COOH)";
		try {
			assertEquals(20,test.calulateMass(formulae) );
		}catch(IllegalArgumentException exception) {
			
		}
	}
	
	@Test
	public void test_When_BracketsNotPlaced_Expected_IllegalArgumentException() {
		MassCalculator test =new MassCalculator();
		String formulae="(CH3COOH";
		try {
			assertEquals(20,test.calulateMass(formulae) );
		}catch(IllegalArgumentException exception) {
			
		}
	}
	
	@Test
	public void test_When_ValidInputPassed_Expected_Integer() {
		MassCalculator test =new MassCalculator();
		String formulae="CH3COOH";
		
		assertEquals(60,test.calulateMass(formulae) );
	}
}
