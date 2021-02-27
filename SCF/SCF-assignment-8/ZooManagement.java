package assignment8;

import java.util.ArrayList;
import java.util.List;

/**Class for managing zoo
 * 
 * @author Hitesh Pareek
 *@since 25-02-2021
 */
public class ZooManagement {
	
	public static void main(String args[])
	{
	 List<Animal> animalList=new ArrayList<Animal>();
	 Zoo zoo=new Zoo();
	 zoo.zooChart.put("mammal", new ArrayList<Zone>());
	 zoo.zooChart.put("reptile", new ArrayList<Zone>());
	 zoo.zooChart.put("bird",new ArrayList<Zone>());
		
	 Animal animal=new Lion("Sheru",2,100);
	 animalList.add(animal);
	 System.out.println(zoo.addAnimal(animal));	
     System.out.println(zoo.removeAnimal(animal));
	}
 
}
