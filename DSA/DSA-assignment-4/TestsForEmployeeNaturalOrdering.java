package GETA2021.DSA.DSAAssignment4;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Test methods of EmployeeNaturalOrdering
 * 
 * @since 11-03-2021
 * @author hitesh.pareek_metacu
 */
public class TestsForEmployeeNaturalOrdering {
	EmployeeNaturalOrdering test = new EmployeeNaturalOrdering();

	@Test
	public void test_When_NullListIsPassed_Expected_NullPointerException() {
		try {
			test.naturalSort(null);
		} catch (NullPointerException exception) {

		}
	}

	@Test
	public void test_When_EmptyListIsPassed_Expected_EmptyStackException() {
		try {
			List<Employee> testList = new LinkedList<Employee>();
			test.naturalSort(testList);
		} catch (EmptyStackException exception) {

		}
	}
	
	@Test
	public void test_When_ValidArgumentPassed_Expected_SortedList() {
		List<Employee> employeeList = new LinkedList<Employee>();
		Employee firstEmployee = new Employee(2, "Hitesh", "f-183");
		Employee secondEmployee = new Employee(6, "Himanshu", "f-40");
		Employee thirdEmployee = new Employee(8, "Sachin", "f-143");
		Employee fourthEmployee = new Employee(10, "Nitin", "f-243");
		Employee fifthEmployee = new Employee(4,"Shubham", "f-112");
		employeeList.add(firstEmployee);
		employeeList.add(secondEmployee);
		employeeList.add(thirdEmployee);
		employeeList.add(fourthEmployee);
		employeeList.add(fifthEmployee);

		employeeList = test.naturalSort(employeeList);
		// We expect that after sorting by name the first employee id will be 2
		assertEquals(2, employeeList.remove(0).id);
	}
}
