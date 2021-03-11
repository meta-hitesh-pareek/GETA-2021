package GETA2021.DSA.DSAAssignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Defines Method to sort Employee by natural order
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class EmployeeNaturalOrdering {

	/**
	 * Sort employee by id
	 * 
	 * @return list of employees sorted by name
	 */
	public List<Employee> naturalSort(List<Employee> allEmployees) {
		if (allEmployees == null) {
			throw new NullPointerException();
		} else if (allEmployees.size() == 0) {
			throw new EmptyStackException();
		}
		Collections.sort(allEmployees, naturalSort);
		List<Employee> sortedList = new ArrayList<Employee>(allEmployees);
		return sortedList;

	}

	/**
	 * Custom compare method sort employee by id
	 */
	private static Comparator<Employee> naturalSort = new Comparator<Employee>() {
		public int compare(Employee firstEmployee, Employee secondEmployee) {
			if (firstEmployee.id > secondEmployee.id) {
				return 1;
			} else if (secondEmployee.id > firstEmployee.id) {
				return -1;
			} else {
				return 0;
			}
		}
	};
}
