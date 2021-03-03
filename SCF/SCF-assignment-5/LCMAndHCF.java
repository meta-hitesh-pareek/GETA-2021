package GETA2021.SCF.SCFAssignment5;

/**
 * Finds LCM and HCF of two numbers
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class LCMAndHCF {

	/**
	 * Calculates the HCF of two given numbers
	 * 
	 * @param firstValue
	 * @param secondValue
	 * @return HCF of firstValue and SecondValue
	 */
	public int HCF(int firstValue, int secondValue) {
		if (firstValue == 0) {
			return secondValue;
		}
		return HCF(secondValue % firstValue, firstValue);
	}

	/**
	 * Calculates the LCM of two given numbers
	 * 
	 * @param firstValue
	 * @param secondValue
	 * @return LCM of firstValue and SecondValue
	 */
	public int LCM(int firstValue, int secondValue) {
		return (firstValue / HCF(firstValue, secondValue)) * secondValue;
	}

}
