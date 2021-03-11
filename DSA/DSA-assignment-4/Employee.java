package GETA2021.DSA.DSAAssignment4;

/**
 * Define Employee and its attributes
 * 
 * @since 11-03-2021
 * @author Hitesh Pareek
 */
public class Employee {
	String name;
	int id;
	String address;

	/**
	 * Initializes Employee attributes
	 * 
	 * @param id
	 * @param name
	 * @param address
	 */
	Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Id of the employee
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the Id of the employee
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the address of the employee
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the address of the employee
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}