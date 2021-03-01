import java.util.Scanner;

/**Class to perform operation on Hexadecimal values
 * 
 * @since 28-02-2021
 * @author Hitesh Pareek
 *
 */
public class HexaCalc {

	final private int base=16;
	
	/**Method to convert hexadecimal value to decimal value
	 * 
	 * @param hexadecimal value
	 * @return decimal value
	 */
	public int hexToDec(String hex)
	{
		int num=Integer.parseInt(hex,base);
		
		return num;
	}
	
	/**Method to convert decimal value to hexadecimal value
	 * 
	 * @param decimal value
	 * @return hexadecimal value
	 */
	public String decToHex(int num)
	{
		String hex=Integer.toHexString(num);
		
		return hex;
	}
	
	/**Method to add two hexadecimal values
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public String add(String hexa1, String hexa2)
	{
    	return decToHex(hexToDec(hexa1)+hexToDec(hexa2));
	}
	
	/**Method to subtract two hexadecimal values
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public String subtract(String hexa1,String hexa2)
	{
		return decToHex(hexToDec(hexa1)-hexToDec(hexa2));
	}
	
	/**Method to divide two hexadecimal values
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public String divide(String hexa1,String hexa2){
		
		return decToHex(hexToDec(hexa1)/hexToDec(hexa2));
	}
	
	/**Method to add multiply hexadecimal values
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public String multiply(String hexa1,String hexa2)
	{
		return decToHex(hexToDec(hexa1)*hexToDec(hexa2));
	}
	
	/**Method to check if one decimal value is less than other
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public boolean isLessThan(String hexa1,String hexa2)
	{
		boolean flag=false;
		
		if(hexa1.length()<hexa2.length())
		{
			return true;
		}
		else if(hexa1.length()>hexa2.length())
		{
			return false;
		}
		else
		{
		for(int i=0;i<hexa1.length();i++)
		{
			if(hexa1.charAt(i)<hexa2.charAt(i))
			{
				flag=true;
                break;
			}
		}
			return flag;
		}
    }
	
	/**Method to check if one decimal value is greater than other
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public boolean isGreaterThan(String hexa1,String hexa2)
	{
		boolean flag=false;
		
		if(hexa1.length()>hexa2.length())
		{
			return true;
		}
		else if(hexa1.length()<hexa2.length())
		{
			return false;
		}
		else
		{
		for(int i=0;i<hexa1.length();i++)
		{
			if(hexa1.charAt(i)>hexa2.charAt(i))
			{
				flag=true;
                break;
			}
		}
			return flag;
		}
	}
	
	/**Method to check if two hexadecimal values are equal
	 * 
	 * @param Hexadecimal value
	 * @param Hexadecimal value
	 * @return Hexadecimal String
	 */
	public boolean isEqual(String hexa1,String hexa2)
	{
		boolean flag=true;
		
		if(hexa1.length()!=hexa2.length())
		{
			return false;
		}
		else
		{
        for( int i=0;i<hexa1.length();i++)
         {
        	if(hexa1.charAt(i)!=hexa2.charAt(i))
        	{
          	  flag=false;
              break;
        	}
		 }
         return flag;
		}
     }
	
	public static void main(String args[])
	{
		HexaCalc obj =new HexaCalc();
		Scanner sc=new Scanner(System.in);
		int  num=sc.nextInt();
		
		System.out.println(obj.decToHex(num));
		sc.close();
		
	}
}
