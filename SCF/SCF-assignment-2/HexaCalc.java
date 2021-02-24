import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class HexaCalc {

	final private int  base=16;
	public int hexToDec(String hex)
	{
		int num=Integer.parseInt(hex,16);
		return num;
		
	}
	public String decToHex(int num)
	{
		String hex=Integer.toHexString(num);
		return hex;
	}
	
	
	public String add(String hexa1, String hexa2)
	{
		int deci1,deci2;
    	int result;
		deci1=hexToDec(hexa1);
		deci2=hexToDec(hexa2);
		result=deci1+deci2;
		
		return decToHex(result);
	}
	
	public String subtract(String hexa1,String hexa2)
	{
		int deci1,deci2;
		int result;
		deci1=hexToDec(hexa1);
		deci2=hexToDec(hexa2);
		result=deci1-deci2;
    
		return decToHex(result);
		
	}
	public String divide(String hexa1,String hexa2){
		int deci1,deci2;
		int result;
		deci1=hexToDec(hexa1);
		deci2=hexToDec(hexa2);
		result=deci1/deci2;
	
		return decToHex(result);
	}
	
	public String multiply(String hexa1,String hexa2)
	{
		int deci1,deci2;
		int result;
		deci1=hexToDec(hexa1);
		deci2=hexToDec(hexa2);
		result=deci1 * deci2;
		
		return decToHex(result);
		
		
	}
	
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
		
		
		
	}
}
