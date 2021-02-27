package assignment8;


public abstract class Reptiles extends Animal {
	


/**Constructor for setting reptile attributes
 * 
 * @param Name of reptile
 * @param Age of reptile in years
 * @param Weight of reptile
 */
	Reptiles(String name,int ageInYears,int weight){
		super(name,ageInYears,weight);
		this.type="reptile";
		
	}
}
