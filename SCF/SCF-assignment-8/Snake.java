package assignment8;

public class Snake extends Reptiles {
	
	/**Method to get sound snake
	 * 
	 * @return Sound of snake as String
	 */
	 public String  getSound()
	  {
		return "hiss";
	  }
	 
	 /**Constructor for setting snake attributes
	  * 
	  * @param Name of snake
	  * @param Age of snake in years
	  * @param Weight of snake
	  */
	Snake(String name,int ageInYears,int weight)
	{
		super(name,ageInYears,weight);
	}
}
