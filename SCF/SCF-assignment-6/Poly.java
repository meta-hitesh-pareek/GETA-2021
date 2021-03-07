package assignment6;


public class Poly {

	private final int polyArray[][];
	
	public Poly(int input[][])
	{
		this.polyArray=input;
	}
	
	public int[][] getPoly()
	{
		return polyArray.clone();
	}
	
	
	private static int[][] sorting(int[][] inputArray)
	{
		int tempDegree,tempCoeff,length=inputArray.length;
		for(int leftIndex=0;leftIndex<length-1;leftIndex++)
		{
			for(int rightIndex=0;rightIndex<length-1;rightIndex++)
			{
				if(inputArray[rightIndex][1]<inputArray[rightIndex+1][1]) {
					tempCoeff=inputArray[rightIndex+1][0];
					inputArray[rightIndex+1][0]=inputArray[rightIndex][0];
					inputArray[rightIndex][0]=tempCoeff;
					
					tempDegree=inputArray[rightIndex+1][1];
					inputArray[rightIndex+1][1]=inputArray[rightIndex][1];
					inputArray[rightIndex][1]=tempDegree;
				}
			}
		}
	return inputArray;
	}
	
	public int evaluate(int num)
	{
		int  totalSum=0;
		for(int index=0;index<polyArray.length;index++)
		{
			totalSum+=polyArray[index][0]*Math.pow(num, polyArray[index][1]);
		}
			return totalSum;
		
	}

	public int degree()
	{
		int [][] arr=sorting(this.polyArray);
		return arr[0][1];
	}
	
	public static int[][] addPoly(Poly p1,Poly p2)
	{
		int firstSorted[][]=sorting(p1.polyArray);
		int secondSorted[][]=sorting(p2.polyArray);
		
		int coeff=0;
		int power=0;
		int resultIndex=0;
		
		int result[][]=new int[firstSorted.length+secondSorted.length][2];
		
		while(coeff <firstSorted.length & power<secondSorted.length)
		{
			if(firstSorted[coeff][1]==secondSorted[power][1])
			{
				result[resultIndex][0]=firstSorted[coeff][0]+secondSorted[power][0];
				result[resultIndex][1]=firstSorted[coeff][1];
				coeff++;
				resultIndex++;
				power++;
			}
			
			else if(firstSorted[coeff][1]>secondSorted[power][1])
			{
				result[resultIndex][0]=firstSorted[coeff][0];
				result[resultIndex][1]=firstSorted[coeff][1];
				coeff++;
				resultIndex++;
				
			}
			else 
			{
				result[resultIndex][0]=secondSorted[power][0];
				result[resultIndex][1]=secondSorted[power][1];
				
				resultIndex++;
				power++;
			}
			
		}
		while(coeff<firstSorted.length)
		{
			result[resultIndex][0]=firstSorted[coeff][0];
			result[resultIndex][1]=firstSorted[coeff][1];
			coeff++;
			resultIndex++;
			
		}
		while(power<secondSorted.length)
		{
			result[resultIndex][0]=secondSorted[power][0];
			result[resultIndex][1]=secondSorted[power][1];
			
			resultIndex++;
			power++;
		}
		return result;
	}
	public static int[][] multiplyPoly(Poly p1,Poly p2)
	{
		int firstSorted[][]=sorting(p1.polyArray);
		int secondSorted[][]=sorting(p2.polyArray);
		int Coeff=0,Power=0;
		int size=firstSorted[0][1]+secondSorted[0][1];
		int result[][]=new int[size+1][2];
	    for(int firstIndex=0;firstIndex<secondSorted.length;firstIndex++)
	    {
	    	for(int secondIndex=0;secondIndex<secondSorted.length;secondIndex++)
	    	{
	    		Coeff=firstSorted[firstIndex][0]*secondSorted[secondIndex][0];
	    		Power=firstSorted[firstIndex][1]+secondSorted[secondIndex][1];
	    		result[Power][0]+=Coeff;
	    		result[Power][1]=Power;
	    	}
	    }
	    return result;
	}
	
	public static void main(String args[])
	{
		int arr1[][]= {{3,2},
		               {2,1},
		               {1,0}};
		int arr2[][]={{4,1},
	               {1,0},
	               };
		Poly p1=new Poly(arr1);
		Poly p2=new Poly(arr2);
		
		int result[][]=addPoly(p1, p2);
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[0].length;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
