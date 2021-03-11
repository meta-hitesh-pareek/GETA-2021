package GETA2021.DSA.DSAAssignment4;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Test methods of EmployeeAccordingToName
 * 
 * @author hitesh.pareek_metacu
 *
 */
public class TestsForEmployeeAccordingToName {
	EmployeeAccordingToName test = new EmployeeAccordingToName();

	@Test
	public void test_When_NullListIsPassed_Expected_NullPointerException() {
		try {
			test.sortByName(null);
		} catch (NullPointerException exception) {

		}
	}

	@Test
	public void test_When_EmptyListIsPassed_Expected_EmptyStackException() {
		try {
			List<Employee> testList = new LinkedList<Employee>();
			test.sortByName(testList);
		} catch (EmptyStackException exception) {

		}
	}

	@Test
	public void test_When_ValidArgumentPassed_Expected_SortedList() {
		List<Employee> employeeList = new LinkedList<Employee>();
		Employee firstEmployee = new Employee(1, "Hitesh", "f-183");
		Employee secondEmployee = new Employee(2, "Himanshu", "f-40");
		Employee thirdEmployee = new Employee(3, "Sachin", "f-143");
		Employee fourthEmployee = new Employee(4, "Nitin", "f-243");
		Employee fifthEmployee = new Employee(5, "Shubham", "f-112");
		employeeList.add(firstEmployee);
		employeeList.add(secondEmployee);
		employeeList.add(thirdEmployee);
		employeeList.add(fourthEmployee);
		employeeList.add(fifthEmployee);

		employeeList = test.sortByName(employeeList);
		// We expect that after sorting by name the first employee will be Himanshu
		assertEquals("Himanshu", employeeList.remove(0).name);
	}
}
