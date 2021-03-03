package GETA2021.SCF.SCFAssignment5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test method of LCMAndHCF Class
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class testCasesForLCMAndHCF {
	LCMAndHCF LcmHcf = new LCMAndHCF();

	@Test
	public void testCaseForLCM_Expected_25() {
		int firstValue = 25;
		int secondValue = 5;

		int actual = LcmHcf.LCM(firstValue, secondValue);
		assertEquals(25, actual);
	}

	@Test
	public void testCaseForHCF_Expected_5() {
		int firstValue = 25;
		int secondValue = 5;

		int actual = LcmHcf.HCF(firstValue, secondValue);
		assertEquals(5, actual);
	}
}
