package assignment4;

/**
 * Class to perform different array operations
 * 
 * @author Hitesh Pareek
 * @since 28-02-2021
 *
 */
public class ArrOperations {

	/**
	 * Method to return number of clumps present in an array
	 * 
	 * @param Array of positive integers
	 * @return The number of clumps present in the given array
	 * @throws Assertion error if array is empty
	 */
	public int countClumps(int arr[]) {
		int totalClumps = 0;
		int currentSameNumbers = 1;

		if (arr.length == 0) {
			throw new AssertionError("Array is empty");
		}

		for (int index = 1; index < arr.length; index++) {
			if (arr[index] == arr[index - 1] && currentSameNumbers < 2) {
				totalClumps++;
				currentSameNumbers++;
			} else if (arr[index] != arr[index - 1] && currentSameNumbers >= 2) {
				currentSameNumbers = 1;
			}
		}

		return totalClumps;
	}

	/**
	 * Method to solve fixXY problem
	 * 
	 * @param Array of positive integers
	 * @param Value of X
	 * @param Value of Y
	 * @return New array with X's and Y's position fixed
	 * @throws Assertion Error
	 */
	public int[] fixXY(int arr[], int x, int y) {
		int xCount = 0;
		int yCount = 0;

		if (arr.length == 0 || arr[arr.length - 1] == x) {
			throw new AssertionError();
		}

		loop: for (int index = 0; index < arr.length; index++) {
			if (arr[index] == x && arr[index+1]!=y) {
				xCount++;
				if (arr[index + 1] == x) {
					throw new AssertionError(false);
				} else {
					for (int j = 0; j < arr.length; j++) {
						if (arr[j] == y) {
							if (j != 0 && arr[j - 1] == x) {
								continue;
							} else {
								yCount++;
								int temp = arr[j];
								arr[j] = arr[index + 1];
								arr[index + 1] = temp;
								continue loop;
							}
						}
					}
				}
			}
		}
		if (xCount != yCount) {
			throw new AssertionError("X and Y are not equal");
		}
		return arr;
	}

	/**
	 * Method for splitting array in two equal sum arrays
	 * 
	 * @param Array of integers
	 * @return -1 if splitting not possible,else the starting index of right split array
	 * @throws Assertion Array
	 */
	public int splitArray(int arr[]) {
		if (arr.length == 0) {
			throw new AssertionError();
		}
		if (arr.length == 1) {
			return -1;
		}
		int leftIndex = 0, leftSum = arr[0];
		int rightIndex = arr.length - 1, rightSum = arr[rightIndex];
		while (leftIndex < rightIndex - 1) {
			if (leftSum <= rightSum) {
				leftIndex++;
				leftSum += arr[leftIndex];
			} else {
				rightIndex--;
				rightSum += arr[rightIndex];
			}
		}
		if (leftSum == rightSum) {
			return rightIndex;
		} else {
			return -1;
		}
	}

	/**
	 * Method to find longest mirror section in array
	 * 
	 * @param Array of integers
	 * @return Size of longest mirror section
	 * @throws Assertion Error
	 */
	public int maxMirror(int arr[]) {
		if (arr.length == 0) {
			throw new AssertionError("Array is empty");
		}
		int arrayLength = arr.length;
		int countLength = 0;
		int maxLength = 0;
		for (int leftIndex = 0; leftIndex < arrayLength; leftIndex++) {
			countLength = 0;
			for (int rightIndex = arrayLength - 1; leftIndex + countLength < arrayLength
					&& rightIndex > -1; rightIndex--) {
				if (arr[leftIndex + countLength] == arr[rightIndex]) {
					countLength++;
				} else {
					if (countLength > 0) {
						maxLength = Math.max(countLength, maxLength);
						countLength = 0;
						rightIndex++;
					}
				}
			}
			maxLength = Math.max(maxLength, countLength);
		}
		return maxLength;
	}

	public static void main(String args[]) {
		int arr[] = {5,6,4,2,4,6,5};
		ArrOperations Ao = new ArrOperations();
        int output[]=Ao.fixXY(arr, 4, 5); 
		
		for(int x:output) {
			System.out.print(x+" ");
		}
    }
}