package GETA2021.DSA.DSAAssignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Defines method for counting unique characters in a string
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class UniqueCount {
	static Map<String, Integer> sameChar = new HashMap<>();
	Set<Character> characterSet = new HashSet<>();

	/**
	 * Count the number of unique characters in a given string
	 * 
	 * @param inputString
	 * @return
	 */
	public int countUniqueCharacters(String inputString) {
		
		if (inputString == null) {
			throw new NullPointerException();
		}
		
		int count = 0;
		
		/*
		 * It will check if result of given string is previously stored or not.
		 * If it is store it will return the stored result
		 */
		for (Map.Entry<String, Integer> m : sameChar.entrySet()) {
			if (m.getKey().equals(inputString)) {
				return m.getValue();
			}
		}

		/*
		 * If it don't find the string in the cache, it will iterate through
		 * whole string to count the unique characters
		 */
		for (int index = 0; index < inputString.length(); index++) {
			char currentCharacter = inputString.charAt(index);
			if (!characterSet.contains(currentCharacter)) {
				count += 1;
				characterSet.add(currentCharacter);
			}
		}

		sameChar.put(inputString, count);
		characterSet.clear();

		return count;
	}
}
