package assignment8;
import java.util.*;

/**Class for creating zoo structure
 * 
 * @author Hitesh Pareek
 * @since 25-02-2021
 */
public class Zoo {
	
	HashMap<String ,ArrayList<Zone>> zooChart=new HashMap<String, ArrayList<Zone>>() ;
	Map<Integer,List<Integer>> LocationOfAnimal=new HashMap<Integer, List<Integer>>();
	static final int zonesAllowed=6;
	static int zonesCreated=0;
	 
	 /**Method to add zone to the zoo
	  * 
	  * @param type of zone
	  * @param zoneId
	  * @return new zone object
	  */
	public Zone addZone(String type)
	{
		Zone zone=null;
	if(zonesAllowed>zonesCreated)
	{
		zonesCreated++;
	    zone=new Zone(type);
		zooChart.get(type).add(zone);
	}
	return zone;
	}
	
/**Method to get the zone
 * 	
 * @param type of zone
 * @return
 */
	public Zone getZone(String type)
	{
		List<Zone> zones =zooChart.get(type);
	    Zone zone=null;
	    
	    if(zones.size()==0)
	    {
	    	zone =new Zone(type);
	    	zones.add(zone);
	    }
	    else
	    {
	        zone=zones.get(zones.size()-1);
	    }
         
	    if(zone.isZoneFull())
	    {
	    	zone=addZone(type);
	    }
	    return zone;
	}
	
/**Mehtod to add new animal to zoo
 * 
 * @param animal
 * @return true if animal added else false
 */
	public boolean addAnimal(Animal animal)
	{
		String typeOfAnimal=animal.type;
		Zone zone=getZone(typeOfAnimal);
		Cage cage=null;
		
		if(zonesCreated==zonesAllowed && zone.isZoneFull())
		{
			return false;
		}
		else
		{
			if(zone!=null)
			{
				cage=zone.getCage();
			}
			if(cage!=null)
			{
				cage.addAnimal(animal);
				List<Integer> locationOfAnimal=new ArrayList<Integer>();
				locationOfAnimal.add(zone.zoneId);
				locationOfAnimal.add(cage.id);
				LocationOfAnimal.put(animal.id,locationOfAnimal);
			}
				return true;
		}
	}
	
	/**Method to remove animal
	 * 	  
	 * @param animal object
	 * @return true if animal remove,else false
	 */
	public boolean removeAnimal(Animal animal)
	{
		boolean isRemoved=false;
		if(!LocationOfAnimal.containsKey(animal.id))
		{
			return false;
		}
		else
		{
			List<Integer> location=LocationOfAnimal.get(animal.id);
			int zoneId=location.get(0);
			int cageId=location.get(1);
			List<Zone> zones=zooChart.get(animal.type);
			int totalZones=zones.size();
			Zone zone=null;
			Cage cage=null;
			
	    	for(int index=0;index<totalZones;index++)
	    	{
	    		if(zones.get(index).zoneId==zoneId)
	    		{
	    			zone=zones.get(index);
	    	        break;
	    		}
	    	}
	    	if(zone!=null)
	    	{
	    		cage=zone.removeAnimalFromCage(cageId);
	    	}
	    	if(cage!=null)
	    	{
	    		isRemoved= cage.removeAnimal(animal);
	    	}
	    return isRemoved;
		}
	}
}

