package GETA2021.DSA.DSAAssignment5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestsForEmployeeSort {

	@Test
	public void test_WhenNullIsPassed_Expected_NullPointerException() {
		try {
		Employee employee1 = new Employee(null, 22, 40000);
		}catch(NullPointerException exception) {
		}
	}
	
	@Test
	public void test_WhenNullListIsPassed_Expected_NullPointerException() {
		try {
		Employee employee1 = new Employee("Hitesh", 22, 40000);
		ArrayList<Employee> list = new ArrayList<Employee>();
		EmployeeSort test =  new EmployeeSort();
		test.sortAccordingToSalary(null);
		}catch(NullPointerException exception) {
		}
	}
	
	@Test
	public void test_When_ValidArgumentPassed_Expected_NullPointerException() {

		Employee employee1 = new Employee("Hitesh", 22, 40000);
		Employee employee2 = new Employee("Naman", 22, 46000);
		Employee employee3 = new Employee("Sachin", 22, 30000);
		Employee employee4 = new Employee("Tanveer", 22, 50000);
		Employee employee5 = new Employee("Nitin", 22, 44000);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);
		list.add(employee5);
		EmployeeSort test =  new EmployeeSort();
		list=test.sortAccordingToSalary(list);
		
		assertEquals("Tanveer", list.remove().name);
		}
	}
	

