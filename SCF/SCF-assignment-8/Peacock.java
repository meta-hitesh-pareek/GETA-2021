package assignment8;

/**Class for animal Peacock
 * 
 * @since24-02-2021
 * @author Hitesh Pareek
 *
 */
public class Peacock extends Birds{

	/**Method to get sound peacock
	 * 
	 * @return Sound of peacock as String
	 */
	 public String  getSound()
	  {
		return "meoo";  
	  }
	 
	 /**Constructor to set attributes of peacock
	  * 
	  * @param Name of peacock
	  * @param Age of peacock in years
	  * @param Weight of peacock
	  */
	Peacock(String name,int ageInYears,int weight)
	{
		super(name,ageInYears,weight);
	}
		

}
