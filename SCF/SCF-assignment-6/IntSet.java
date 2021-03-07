package assignment6;

/**
 * Perform operation between two sets
 * 
 * @since 07-03-2021
 * @author Hitesh Pareek
 *
 */
public class IntSet {
	int set[];

	/**
	 * Initialize elements of given set
	 * 
	 * @param inputSet
	 */
	IntSet(int inputSet[]) {
		this.set = inputSet;
	}

	/**
	 * Prints the elements of the set
	 */
	public void printSet() {
		for (int index = 0; index < set.length; index++) {
			System.out.print(set[index] + " ");
		}
	}

	/**
	 * Checks if given value is a member of set
	 * 
	 * @param inputValue
	 * @return true if it is a member, else false
	 */
	public boolean isMember(int inputValue) {
		for (int index = 0; index < set.length; index++) {
			if (set[index] == inputValue) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find the size of set
	 * 
	 * @return size of set
	 */
	public int size() {
		return set.length;
	}

	/**
	 * Check if a given set is a subset of current set or not
	 * 
	 * @param compareSet
	 * @return true if given set is a subset, else false
	 */
	public boolean isSubset(IntSet compareSet) {
		int inputSet[] = compareSet.set;

		if (this.size() != compareSet.size()) {
			return false;
		}
		for (int index = 0; index < this.size(); index++) {
			boolean flag = false;

			for (int compareIndex = 0; compareIndex < compareSet.size(); compareIndex++) {
				if (set[index] == inputSet[compareIndex]) {
					flag = true;
				}
			}

			if (flag == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Finds the complement of the current set
	 * 
	 * @param userSet
	 * @return complement
	 */
	public IntSet getComplement() {
		int currentSet[]=this.set;
		int resultSet[] = new int[1000 - currentSet.length];
		int position = 0;

		for (int index = 1; index <= 1000; index++) {
			if (!this.isMember(index)) {
				resultSet[position++] = index;
			}
		}
		IntSet complimentSet = new IntSet(resultSet);
		return complimentSet;
	}

	/**
	 * Create a union set of the two given set
	 * 
	 * @param firstInput
	 * @param secondInput
	 * @return union set of given two set
	 */
	public IntSet union(IntSet firstInput, IntSet secondInput) {
		int firstSet[] = firstInput.set;
		int secondSet[] = secondInput.set;

		int resultsize = 0;
		for (int index = 0; index < firstSet.length; index++) {
			if (!secondInput.isMember(firstSet[index])) {
				resultsize++;
			}
		}
		resultsize += firstSet.length;
		int resultSet[] = new int[resultsize];
		int currentPosition = 0;
		for (int index = 0; index < firstSet.length; index++) {
				resultSet[currentPosition++] = firstSet[index];
		}

		for (int index = 0; index < secondSet.length; index++) {
			if (!firstInput.isMember(secondSet[index])) {
				resultSet[currentPosition++] = secondSet[index];
			}
		}
		IntSet outputSet = new IntSet(resultSet);
		return outputSet;
	}
}
