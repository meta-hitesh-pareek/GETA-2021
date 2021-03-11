package GETA2021.DSA.DSAAssignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * Test methods of EmployeeSet
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class TestsForEmployeeSet {

	@Test
	public void test_When_WhenNullIsPassed_Expected_NullPointerException() {
		try {
			EmployeeSet test = new EmployeeSet();
			test.addEmployee(null);
		} catch (NullPointerException exception) {

		}
	}

	@Test
	public void test_When_UniqueIdIsAdded_Expected_True() {

		EmployeeSet test = new EmployeeSet();
		Employee firstEmployee = new Employee(1, "Hitesh", "f-183");
		Employee secondEmployee = new Employee(2, "Naman", "g-23");
		test.addEmployee(firstEmployee);

		assertTrue(test.addEmployee(secondEmployee));
	}

	@Test
	public void test_When_SameIdIsAdded_Expected_True() {

		EmployeeSet test = new EmployeeSet();
		Employee firstEmployee = new Employee(1, "Hitesh", "f-183");
		Employee secondEmployee = new Employee(1, "Naman", "g-23");
		test.addEmployee(firstEmployee);

		assertFalse(test.addEmployee(secondEmployee));
	}
}
