package assignment8;

/**Abstract class for animal of type 'Bird'
 * 
 * @author Hitesh Pareek
 *@since 24-02-2021
 */
public abstract class Birds extends Animal{

	Birds(String name,int ageInYears,int weight)
	{
		super(name,ageInYears,weight);
		this.type="birds";
		
	}

}
