package GETA2021.DSA.DSAAssignment4;

import java.util.HashSet;
import java.util.Set;

/**
 * Define method to store employee's information 
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class EmployeeSet {
	private Set<Employee> allEmployees = new HashSet<Employee>();
    
	/**
	 * Method to store unique employee and remove those with duplicate id
	 * 
	 * @param newEmployee
	 * @return true is employee information is saved, else false
	 */
	public boolean addEmployee(Employee newEmployee) {
		if (newEmployee == null) {
			throw new NullPointerException();
		}
		for (Employee oldEmployee : allEmployees) {
			if (oldEmployee.id == newEmployee.id) {
				return false;
			}
		}
		allEmployees.add(newEmployee);
		return true;
	}

}
