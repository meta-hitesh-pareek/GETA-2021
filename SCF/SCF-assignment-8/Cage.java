package assignment8;

import java.util.ArrayList;

/**Class for creating cage structure
 * 
 * @author Hitesh Pareek
 * @since 25-02-2021
 *
 */
public class Cage {
	
private ArrayList<Animal> animalList=new ArrayList<Animal>();
private static int currentAnimalCount=0;
private int ToalAnimalAllowed=10;
static int cageIdAllocator=0;
String cageType;
int id;

/**Constructor to set cage attributes
 * 
 * @param cageType
 * @param id
 */
Cage(String cageType,int id)
{
	this.cageType=cageType;
	this.id=cageIdAllocator++;
}

/**Method to check if cage full
 * 
 * @return boolean */
public boolean isSpaceAvailable() {
	
	if(currentAnimalCount ==ToalAnimalAllowed)
		return true;
	return false;
}

/** Method to add animal in cage
 * 
* @param Animal
* @return  true if animal added,else false
* */
public boolean addAnimal(Animal animal)
{
	if(isSpaceAvailable()==false)
	{
		currentAnimalCount++;
		animalList.add(animal);
		return true;
	}
	else
	{
		return false;
	}
  }

/**Method to remove animal from List
 * 
 * @param Animal
 * @return true if animal removed else false
 */
public boolean removeAnimal(Animal animal)
{
	for(int index=0;index<animalList.size();index++)
	{
		if(animalList.get(index).id==animal.id)
		{
			animalList.remove(index);
			currentAnimalCount--;
			return true;
		}
	}
	return false;
}
 
}
