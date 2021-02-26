package assignment3;

/**
 * Class for calculating area of different shapes
 * @since 25-02-2021
 * @author Hitesh Pareek
 *
 */
public class AreaOfShapes {

	
	/**Method to calculate area of Triangle
	 * 
	 * @param Width
	 * @param Height
	 * @return Area of triangle
	 * @throws Arithimatic exception
	 */
	public double areaOfTriangle(double width,double height) throws ArithmeticException
	{
		double areaOfTriangle=(0.5*width)*height;
		
		return areaOfTriangle;
	}
	
	/**Method to calculate area of a Circle
	 * 
	 * @param Radius of Circle
	 * @return Area of circle
	 * @throws ArithimaticException
	 */
	
	public double areaOfCircle(double radius) throws ArithmeticException
	{
		double areaOfCircle=Math.PI*(radius*radius);
		
		return areaOfCircle;
	}
	
	/**Method to calculate area of a Rectangle
	 * 
	 * @param Width of rectangle
	 * @param  Height of rectangle 
	 * @return Area of rectangle
	 * @throws ArithimaticException
	 */
	public double areaOfRectangle(double width,double height) throws ArithmeticException
	{
		double areaOfRectangle=width*height;
		
		return areaOfRectangle;
	}
	
	/**Method to calculate area of Square
	 * 
	 * @param Side of square
	 * @return Area of square
	 * @throws ArithimaticException
	 */
	public double areaOfSqure(double side)throws ArithmeticException
	{
		double areaOfSquare=side*side;
		return areaOfSquare;
	}
}
