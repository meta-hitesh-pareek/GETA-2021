package GETA2021.DSA.DSAAssignment4;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests methods of UniqueCount
 * 
 * @author hitesh.pareek_metacu
 *
 */
public class TestsForUniqueCount {

	static Map<String, Integer> sameChar = new HashMap<>();
	Set<Character> characterSet = new HashSet<>();

	@Test
	public void test_WhenNullIsPassed_Expected_NullPointerException() {
		UniqueCount test=new UniqueCount();
		try {
			test.countUniqueCharacters(null);
		}catch(NullPointerException exception) {
			
		}
	}
	
	@Test
	public void test_WhenStringIsPassed_Expected_Integer() {
		UniqueCount test=new UniqueCount();
		String testInput ="Hello";
		
		assertEquals(4, test.countUniqueCharacters(testInput));
	}
}
