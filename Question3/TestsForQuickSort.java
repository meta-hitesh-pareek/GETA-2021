package GETA2021.DSA.DSAAssignment6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test method of quick sort
 * 
 * @since 14-03-2021
 * @author Hitesh Pareek
 */
public class TestsForQuickSort {

	@Test
	public void test_When_NullIsPassed_Expected_NullPointerException() {
		try {
		QuickSort test= new QuickSort();
		test.sort(null, null);
		}
		catch(NullPointerException excpetion) {
			excpetion.getMessage();
		}
	}

	@Test
	public void test_EmptyListIsPassed_ExpectedNullPointerException() {
		try {
			QuickSort test =new QuickSort();
			ArrayList<Employee> testList =new ArrayList<Employee>();
			test.sort(testList.head, testList.head);
		}catch(NullPointerException exception) {
			exception.getMessage();
		}
	}
	
	@Test
	public void test_When_ValidArgumentPassed_Expected_SortedList() {
		
			QuickSort test =new QuickSort();
			ArrayList<Employee> testList =new ArrayList<Employee>();
			Employee firstEmployee =new Employee("Hitesh", 22, 40000);
			Employee secondEmployee =new Employee("Sachin", 20, 40000);
			Employee thirdEmployee =new Employee("Naman", 22, 28000);
			Employee fourthEmployee =new Employee("Himanshu", 24, 48000);
			
			testList.add(firstEmployee);
			testList.add(secondEmployee);
			testList.add(thirdEmployee);
			testList.add(fourthEmployee);
			test.sort(testList.head, testList.head);
			
			assertEquals("Himanshu", testList.remove().name);
	}
}
