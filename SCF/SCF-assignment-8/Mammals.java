package assignment8;


abstract class Mammals extends Animal{
	
	
	/**Constructor for setting mammal attributes
	 * 
	 * @param Name of mammal
	 * @param Age of mammal in years
	 * @param Weight of mammal
	 */
	Mammals(String name,int ageInyears,int weight)
	{		
		super(name,ageInyears,weight);
		this.type="mammal";
		
	}
}
