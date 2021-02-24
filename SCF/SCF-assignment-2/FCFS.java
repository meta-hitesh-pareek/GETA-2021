
public class FCFS {
	
	
	public static int[] CompletionTime(int arr[][])
	{
		int lastExecutedTime=0;
		int result[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i][0]>lastExecutedTime)
			{
				lastExecutedTime=arr[i][0];
				
			}
			result[i]=arr[i][1]+lastExecutedTime;
			lastExecutedTime+=arr[i][1];
			
		}
		
		return result;
		
	}
	public static int[] turnAroundTime(int arr[][])
	{
		int TatResult[]=new int[arr.length];
		int lastExecutedTime=0;
		int completionTime;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i][0]>lastExecutedTime)
			{
				lastExecutedTime=arr[i][0];
				
			}
			completionTime=arr[i][1]+lastExecutedTime;
			lastExecutedTime+=arr[i][1];
			TatResult[i]=completionTime-arr[i][0];
			
		}
		
		return TatResult;
		
	}
	public static int[] waitingTime(int arr[][])
	{
		int waitingTimeResult[]=new int[arr.length];
		int lastExecutedTime=0;
		int TurnAroundTime;
		int completionTime;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i][0]>lastExecutedTime)
			{
				lastExecutedTime=arr[i][0];
				
			}
			completionTime=arr[i][1]+lastExecutedTime;
			lastExecutedTime+=arr[i][1];
			TurnAroundTime=completionTime-arr[i][0];
			waitingTimeResult[i]=TurnAroundTime-arr[i][1];
			
		}
		
		return waitingTimeResult;
		
	}
	public static int averageWaitingTime(int arr[][])
	{
		int avgwait;
		int totalwait=0;
		int waitArray[]=waitingTime(arr);
		for(int x:waitArray)
		{
			totalwait+=x;
		}
		int TotalProcesses=waitArray.length;
		avgwait=totalwait/TotalProcesses;
		
		return avgwait;
		
	}
	public static int MaxWaitingTime(int arr[][])
	{
		int MaxWait=0;
		int waitArray[]=waitingTime(arr);
		for(int x:waitArray)
		{
			MaxWait=Math.max(MaxWait, x);
		}
		
		return MaxWait;
		
	}
	public static void main(String args[])
	{
		
		int arr[][]={{0,10},
		             {6,20},
		             {60,10},
		             {110,5}};
		
		System.out.println("completion Time of all process is");
		int completionTime[]=CompletionTime(arr);
		int Tat[]=turnAroundTime(arr);
		int WaitingTime[]=waitingTime(arr);
		int AvgWaitingTime=averageWaitingTime(arr);
		for(int i=0;i<completionTime.length;i++)
		{
			System.out.println("Completion time for process "+(i+1)+" is "+completionTime[i]);
		}
		for(int i=0;i<Tat.length;i++)
		{
			System.out.println("Turn Around Time time for process "+(i+1)+" is "+Tat[i]);
		}
		for(int i=0;i<WaitingTime.length;i++)
		{
			System.out.println("Waiting  Time time for process "+(i+1)+" is "+WaitingTime[i]);
		}
		System.out.println("Average Waiting time is"+AvgWaitingTime);
		System.out.println("max waiting time is"+MaxWaitingTime(arr));
	}

}
