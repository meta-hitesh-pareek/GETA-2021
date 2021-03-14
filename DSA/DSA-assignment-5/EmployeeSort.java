package GETA2021.DSA.DSAAssignment5;

/**
 * Sort employee according to salary
 * 
 * @since 12-03-2021
 * @author Hitesh Pareek
 */
public class EmployeeSort {

	/**
	 * Sort employees according to salary and return sorted list
	 * 
	 * @param employeeList
	 * @return sorted list
	 */
	public ArrayList<Employee> sortAccordingToSalary(
			ArrayList<Employee> employeeList) {
		if (employeeList.size() == 1) {
			return employeeList;
		}

		Node<Employee> previous = employeeList.head;
		Node<Employee> current = employeeList.head.next;

		while (previous.next != null) {
			current = previous.next;
			while (current != null) {
				if (previous.data.salary > current.data.salary
						|| previous.data.age > current.data.age) {

					Employee swapNode = previous.data;
					previous.data = current.data;
					current.data = swapNode;

				}
				current = current.next;
			}
			previous = previous.next;
		}
		return employeeList;
	}
}
