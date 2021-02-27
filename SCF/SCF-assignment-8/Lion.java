package assignment8;

public class Lion extends Mammals{
	
	/**Method to get sound of the Lion
	 * 
	 */
	@Override
  public String  getSound()
  {
	return "roar";
		
  }
	
	/**Constructor for setting Lion attributes
	 * 
	 * @param Name of the Lion
	 * @param Age of the Lion in Years
	 * @param Weight of the Lion in Kg
	 */
   Lion(String name,int ageInYears,int weight)
   {
	super(name,ageInYears,weight);
   }
}
