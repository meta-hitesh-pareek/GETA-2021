/**Class to implement First Come First Serve algorithm
 * 
 * @author Hitesh Pareek
 *@since 22-02-2021
 */
public class FCFS {
	
	/**Method to find out the completion time of all the processes
	 * 
	 * @param 2-D Array containing arrival time and burst time of processes
	 * @return An array with the completion time of each process
	 */
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
	
	/**Method to find out the Turn Around Time of all the processes
	 * 
	 * @param 2-D Array containing arrival time and burst time of processes
	 * @return Return an array with the Turn Around Time of each process
	 */
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

	/**Method to find out the Waiting Time of all the processes
	 * 
	 * @param 2-D Array containing arrival time and burst time of processes
	 * @return Return an array with the Waiting Time of each process
	 */
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
	
	/**Method to find out the Average Waiting Time of the given process processes
	 * 
	 * @param 2-D Array containing arrival time and burst time of processes
	 * @return Integer value as average waiting time of the given processes
	 */
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
	
	/**Method to find out the Maximum Waiting Time of the given process processes
	 * 
	 * @param 2-D Array containing arrival time and burst time of processes
	 * @return Integer value as Maximum Waiting Time of the given processes
	 */
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
