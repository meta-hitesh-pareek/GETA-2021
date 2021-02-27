package assignment8;

/**Class for creating animal object
 * 
 * @author Hitesh Pareek
 * @since 25-02-2021
 *
 */
abstract class Animal {
    int id;
	int ageInYears,weight;
	String type;
	
	Animal(String name,int ageInYears,int weight)
	{
		this.name=name;
		this.ageInYears=ageInYears;
		this.weight=weight;
		
		id=(int)Math.random()*1000;
	}
	
	/**Abstract method for getting sound of different animals
	 * 
	 * @return sound of animal
	 */
	abstract public String  getSound();
	String name;
	

}
