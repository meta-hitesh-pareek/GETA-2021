package Assignment3;

public final class IntSet {
	
	final private int arr[]=new int[1000];
	
IntSet( int arr[])
{
    for(int i=0;i<arr.length;i++)
    {
    	this.arr[arr[i]-1]=1;
    	
    }
	
}	
final public int[] printSet()
{
	final int thisArray[]=this.arr;
    int newArray[]=new int[this.size()];
    int k=0;
    for(int j=0;j<1000;j++)
    {
    	if(thisArray[j]==1)
    	{
    		newArray[k]=j+1;
    		k++;
    	}
    }
    
    return newArray;
}
final public boolean isMember(final int x)
{
	if(arr[x-1]==1)
		return true;
	else
		return false;
}
final public int size()
{
	int size=0;
	for(int i=0;i<arr.length;i++)
	{
		if(arr[i]==1)
		{
			size++;
			
		}
	}
	return size;
	
}
final public  boolean isSubset(IntSet obj)
{
	boolean flag=true;
	final int thisArray[]=this.arr;
	final int setArray[]=obj.arr;
	
	for(int i=0;i<1000;i++)
	{
		if(setArray[i]==1 && thisArray[i]!=1)
		{
			flag=false;
			break;
		}
	}
	return flag;
	
	
}
final public IntSet getComplement()
{
	final int thisArray[]=this.arr;
    final int size=1000-(this.size());
    final int newArray[]=new int[size];
    int j=0;
    for(int i=0;i<1000;i++)
    {
      if(thisArray[i]==0)
      {
    	  newArray[j]=i+1;
    	  j++;
      }
    	
    }
    IntSet obj =new IntSet(newArray);
    return obj;
}
	public static void main(String args[])
	{
		int arr[]={1,2,4,5};
		int arr2[]={2,4,1,5};
	IntSet obj1=new IntSet(arr);
    IntSet obj2=new IntSet(arr2);
    
    
//    System.out.println(obj1.size());
//    System.out.println(obj1.isSubset(obj2));
    IntSet s2=obj1.getComplement();
    int newArray[]=s2.printSet();    
    for(int x:newArray)
    	System.out.print(x+" ");
	}
	
}
