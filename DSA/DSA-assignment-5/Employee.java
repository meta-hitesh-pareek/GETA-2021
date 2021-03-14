package GETA2021.DSA.DSAAssignment5;

/**
 * Define attributes of Employee
 * 
 * @since 14-03-2021
 * @author Hitesh Pareek
 */
public class Employee {
	public String name;
	public int id;
	public int age;
	public int salary;
	static int idCounter;

	/**
	 * Initialize employee information
	 * 
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name, int age, int salary) {
		if(name==null||age<=0||salary<=0) {
			throw new NullPointerException();
		}
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * Get the name of the employee
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the employee
	 * 
	 * @return name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the id of the employee
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id of the employee
	 * 
	 * @return id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the age of the employee
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set the age of the employee
	 * 
	 * @return age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Get the salary of the employee
	 * 
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Set the salary of the employee
	 * 
	 * @return salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
