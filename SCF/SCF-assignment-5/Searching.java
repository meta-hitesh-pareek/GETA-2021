package GETA2021.SCF.SCFAssignment5;

/**
 * Implements searching algorithm using recursion
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class Searching {

	/**
	 * Search value from given set of inputs using Linear Search
	 * 
	 * @param inputArray
	 * @param lowerBound
	 * @param UpperBound
	 * @param value
	 * @return Index of the value if value is found, else -1
	 * @throws AssertionError
	 */
	public int LinearSearch(int[] inputArray, int lowerBound, int UpperBound,int value) throws AssertionError{
		if(inputArray.length==0) {
			throw new AssertionError("Array is empty");
		}
		if (UpperBound < lowerBound) {
			return -1;
		} else {
			if (inputArray[lowerBound] == value) {
				return lowerBound;
			} else if (inputArray[UpperBound] == value) {
				return UpperBound;
			} else {
				return LinearSearch(inputArray, lowerBound + 1, UpperBound - 1,
						value);
			}
		}
	}

	/**
	 * Search value from given set of inputs using Binary Search
	 * 
	 * @param inputArray
	 * @param lowerBound
	 * @param UpperBound
	 * @param value
	 * @return Index of the value if value is found, else -1
	 */
	public int BinarySearch(int[] inputArray, int lowerBound, int UpperBound,int value) {
		if (UpperBound > lowerBound) {
			int mid = lowerBound + (UpperBound - 1) / 2;

			if (inputArray[mid] == value) {
				return mid;
			}
			if (value < inputArray[mid]) {
				return BinarySearch(inputArray, lowerBound, mid - 1, value);
			}
			return BinarySearch(inputArray, mid+1, UpperBound, value);
		}
		return -1;
	}
}