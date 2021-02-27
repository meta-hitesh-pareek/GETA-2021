package assignment8;

import java.util.ArrayList;

/**Class for creating zone of different types
 * 
 * @author hitesh.pareek_metacu
 *
 */
public class Zone {
	
	private ArrayList<Cage> cageList =new ArrayList<Cage>();
    private String zoneType;
    static int idAllocator=1;
    public  int zoneId;
    private int currentCagesCount=0;
    private int CagesAllowed=10;
    static int cageid=0;

   Zone(String zoneType)
   {
	   this.zoneType=zoneType;
       zoneId=idAllocator++;	   
   }
   
   /**Method to check if zone is full
    * @return boolean */
  public boolean isZoneFull()
  {
	  if(currentCagesCount==CagesAllowed)
	  {
		  Cage cage =getCage();
		  if(cage.isSpaceAvailable())
		  {
			  return true;
		  }
	  }
	  return false;
  }
  
  /**Method for getting cage
   * @return Cage object */
  public Cage getCage() {
	  Cage cage=null;
  if(cageList.size()!=0)
  {
    cage =cageList.get(currentCagesCount-1);
  }
  else
  {
	  cage=addCage();
  }
   return cage;
  }
  
  /** Method to add cage
   * @return Cage
   */
  public Cage addCage()
  {
	  Cage cage=null;
	  if(currentCagesCount<CagesAllowed)
	  {
		  cage =new Cage(this.zoneType,cageid++);
		  cageList.add(cage);
		  currentCagesCount++;
	  }
	  return cage;
  }
  
  /**Method to get the cage from where the animal is to be removed
   * 
   * @param cageId
   * @return Cage where the animal is present
   */
  public Cage removeAnimalFromCage(int cageId)
  {
	  for(int i=0;i<cageList.size();i++)
	  {
		  if(cageList.get(i).id==cageId)
		  {
			  return cageList.get(i);
		  }
	  }
	  return null;
  }
   
}
