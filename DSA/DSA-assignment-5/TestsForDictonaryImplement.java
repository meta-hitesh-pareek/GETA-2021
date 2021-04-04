package GETA2021.DSA.DSAAssignment5;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;

/**
 * Tests for DictonaryImplement
 * 
 * @since 13-03-2021
 * @author Hitesh Pareek
 */
public class TestsForDictonaryImplement {

	@Test
	public void test_ForDictonaryImplement_When_NullIsPassed_Expected_NullPointerExetion()
			throws JSONException {
		try {
			DictonaryImplement test = new DictonaryImplement(null);
		} catch (NullPointerException exception) {

		}
	}

	@Test
	public void test_ForDictonaryImplement_When_InvalidStringIsPassed_Expected_NullPointerExetion()
			throws JSONException {
		try {
			String testValue = "sfsf";
			DictonaryImplement test = new DictonaryImplement(testValue);
		} catch (NullPointerException exception) {

		}
	}
	
	@Test
	public void test_ForDictonaryImplement_When_ValidStringIsPassed_Expected_Value()
			throws JSONException {
		
			String testValue = "{\"1\":\"java\",\"2\":\"JS\",\"3\":\"Python\"}";
			DictonaryImplement test = new DictonaryImplement(testValue);
			test.add(4, "Kotlin");
			
			assertEquals("Kotlin", test.get(4));
			
		}
	
	@Test
	public void test_ForSortAccordingToKeys_When_ValidStringIsPassed_Expected_SortedList()
			throws JSONException {
		
			String testValue = "{\"1\":\"java\",\"2\":\"JS\",\"3\":\"Python\"}";
			DictonaryImplement test = new DictonaryImplement(testValue);
			test.add(4, "Kotlin");
			
			ArrayList<KeyValue<Integer, String>> sortedList =test.sortAccordingToKeys(test.dictTree.root);
			
			assertEquals("Kotlin", sortedList.remove().value);
			
		}
	
	@Test
	public void test_ForSortAccordingToCondition_When_ValidStringIsPassed_Expected_SortedList()
			throws JSONException {
		
			String testValue = "{\"1\":\"java\",\"2\":\"JS\",\"3\":\"Python\"}";
			DictonaryImplement test = new DictonaryImplement(testValue);
			test.add(4, "Kotlin");
			
			ArrayList<KeyValue<Integer, String>> sortedList =test.sortCondition(2, 3);
			
			assertEquals("Python", sortedList.remove().value);
		}
	}
	

