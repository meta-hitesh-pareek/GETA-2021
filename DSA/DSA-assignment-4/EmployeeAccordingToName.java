package GETA2021.DSA.DSAAssignment4;

import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

/**
 * Defines Method to sort Employee by name
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class EmployeeAccordingToName {

	/**
	 * Sort employee by name
	 * 
	 * @return list of employees sorted by name
	 */
	public List<Employee> sortByName(List<Employee> employeeList) {
		if(employeeList==null) {
			throw new NullPointerException();
		}else if(employeeList.size()==0) {
			throw new EmptyStackException();
		}
		List<Employee> empList = new LinkedList<Employee>(employeeList);
		Collections.sort(empList, sortByName);
		return empList;
	}

	/**
	 * Custom compare method sort employee by name
	 */
	private static Comparator<Employee> sortByName = new Comparator<Employee>() {
		public int compare(Employee firstEmployee, Employee secondEmployee) {
			return (firstEmployee.name.compareTo(secondEmployee.name));
		}
	};
}
