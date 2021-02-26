package assignment3;

/**Custom String class
 * @since 25-02-2021
 * @author hitesh pareek
 *
 */
public class StringManipulation {

	/** Method to check two string equal or not
	 * @param String
	 * @param String
	 * @return Integer value 1 if string equal ,else 0
	 */
	public int compareStirngs(String string1,String string2)
	{
	 int string1Length=string1.length();
	 int string2Length=string2.length();
     if(string1Length!=string2Length)
	    {
			return 0;
		}
	 for(int stringLength=0;stringLength<string1Length;stringLength++)
       	{
			if(string1.charAt(stringLength)!=string2.charAt(stringLength))
			{
				return 0;
			}
		}
		return 1;
	}
	
	/** Method to return the reverse of the string 
	 * @param String
	 * @return reverse of given String
	 */
	public String reverseOfString(String string)
	{
		String reverseString="";
		if(string==null)
		{
			return null;
		}
		else
		{
		  for(int index=string.length()-1;index>=0;index--)
     		{
			reverseString=reverseString+string.charAt(index);
	    	}
	    }
		return reverseString;
	}
	
	/**method to change cases of the characters of string
	 * @param string
	 * @return string with its character changed to different case
	 */
	public String stringCaseChange(String string)
	{
		String changedString="";
		
		if(string==null)
		{
			return null;
		}
		for(int index=0;index<string.length();index++)
		{
			if(string.charAt(index)>='a'&& string.charAt(index)<='z')
			{
				 int charValue=(int)string.charAt(index);
			     charValue=charValue-32;
			     char changedChar=(char)charValue;
                 changedString+=changedChar;
			}
			if(string.charAt(index)>='A'&& string.charAt(index)<='Z')
			{
				 int charValue=(int)string.charAt(index);
			     charValue=charValue+32;
			     char changedChar=(char)charValue;
                 changedString+=changedChar;
				
			}
		}
		return changedString;
	}	
	
	/**Method to return longest word in a string
	 * 
	 * @param String
	 * @return longest word in string
	 */
	public String longestWord(String string)
	{
		String longestWord="";
		String currentWord="";
		int countLength=0;
		int maxLength=0;
		if(string==null)
		{
			return null;
		}
		for(int index=0;index<string.length();index++)
		{
			if(string.charAt(index)==' '||index==string.length()-1)
			{
				if(index==string.length()-1)
				{
					currentWord+=string.charAt(index);
					countLength++;
				}
				if(countLength>=maxLength)
				{
					longestWord=currentWord;
					maxLength=countLength;
				}
				
				countLength=0;
				currentWord="";
			}
			else
			{
			    currentWord+=string.charAt(index);
				countLength++;
			}
			
		}
		return longestWord;
	}
	
	public static void main(String args[])
	{
		StringManipulation s=new StringManipulation();
		System.out.println(s.longestWord("Gentleman my name is hitesh pareek"));
	}
	
}
