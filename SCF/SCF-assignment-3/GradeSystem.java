package assignment3;

/**Class for calculating grades of students
 *
 * @since 25-02-2021
 * @author Hitesh Pareek
 *
 */

public class GradeSystem {

	/** Method to find maximum of two numbers
	 * 
	 * @param First number
	 * @param  Second number
	 * @return Maximum of two numbers
	 */
	private float max(float num1,float num2)
	{
		if(num1>num2) {
			return num1;
		}
		else
		{
			return num2;
		}
	}
	
	/** Method to find minimum of two numbers
	 * 
	 * @param First number
	 * @param Second number
	 * @return Minimum of two numbers
	 */
	private float min(float num1,float num2)
	{
		if(num1<num2)
		{
			return num1;
		}
		else
		{
			return num2;
		}
	}
	
	/** Method to return average of all grades
	 * 
	 * @param Array of positive integers having grades of students 
	 * @return Average grade of all students
	 * @throws Arithimatic exception in some case
	 */
	public float averageGrade(int[] allGrades) throws ArithmeticException
	{
		int totalStudents=allGrades.length;
		float sumOfAllGrades=0.00f;
		float averageGrade;
		
		for(int index=0;index<allGrades.length;index++)
		{
        sumOfAllGrades+=allGrades[index];
		}
		averageGrade=sumOfAllGrades/totalStudents;
		return averageGrade;
	}
	
	/**Method
	 * 
	 * @param Array of positive float numbers having grade of students 
	 * @return Maximum of all grades
	 */
public float maxOfAllGrades(float[] allGrades) throws ArithmeticException
{
	float maxGrade=0.00f;
	
	for(int index=0;index<allGrades.length;index++)
	{
     maxGrade=max(maxGrade,allGrades[index]);	
	}
	return maxGrade;
}

/**Method to find minimum grade
 * 
 * @param Array of float containing grades
 * @return Minimum grade of all grade
 * @throws Arithimatic Exception
 * 
 */
public float minOfAllGrades(float[] allGrades) throws ArithmeticException
{
float minGrade=0.00f;

for(int index=0;index<allGrades.length;index++)
{
 minGrade=min(minGrade,allGrades[index]);	
}
return minGrade;
}

/** Method to find percentage of student passed
 * 
 * @param Array having grades of all the students
 * @return Number of students passed
 */
public float percentageOfPassedStudents(float[] allGrades) throws ArithmeticException
{
	int numberOfStudentsPassed=0;
	int totalNumberOfStudents=allGrades.length;
	float passingMarks=40.00f;
	float percentOfStudentsPassed=0.00f;
	
 for(int index=0;index<allGrades.length;index++)
  {
    if(allGrades[index]>=passingMarks)
    {
    	numberOfStudentsPassed++;
    }
  }
	percentOfStudentsPassed=(numberOfStudentsPassed*100)/totalNumberOfStudents;
	return percentOfStudentsPassed;
}
	
	public static void main(String args[])
	{
		float arr[]= {2.22f,42.44f,46.22f};
		GradeSystem g=new GradeSystem();
		System.out.println(g.percentageOfPassedStudents(arr));
		
	}
}
