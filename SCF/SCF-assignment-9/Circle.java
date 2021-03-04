package GETA2021.SCF.SCFAssignment9;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Creates shape Circle and implement different functions like
 * getTtimeStamp,getShapeType,getPerimeter,getOrigin getArea,isPointEnclosed
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class Circle implements Shape {
	final String shapeType = Shape.shapeType.Circle.toString();
	double radius;
	Point origin;
	Timestamp timeStamp;

	/**
	 * Constructor to create Circle
	 * 
	 * @param origin
	 * @param radius
	 */
	Circle(Point origin, double radius) {
		this.radius = radius;
		this.origin = origin;
		this.timeStamp = new Timestamp(new Date().getTime());
	}

	/**
	 * Finds distance of point from origin
	 * 
	 * @return Distance
	 */
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(origin.xCoordinate, 2)
				+ Math.pow(origin.yCoordinate, 2));
	}

	/**
	 * Finds Distance between two given point
	 * 
	 * @param firstPoint
	 * @param secondPoint
	 * @return
	 */
	private double distanceBtwTwoPoints(Point firstPoint, Point secondPoint) {
		double differenceX = firstPoint.xCoordinate - secondPoint.xCoordinate;
		double differenceY = firstPoint.yCoordinate - secondPoint.yCoordinate;

		return Math.sqrt(Math.pow(differenceX, 2) + Math.pow(differenceY, 2));
	}

	/**
	 * Find time stamp when the shape was created
	 * 
	 * @return TimeStamp
	 */
	@Override
	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * Return the shape type of shape
	 * 
	 * @return String
	 */
	@Override
	public String getShapeType() {
		return shapeType;
	}

	/**
	 * Finds perimeter of the shape
	 * 
	 * @return Perimeter
	 */
	@Override
	public double getPerimeter() {
		return (2 * (Math.PI) * radius);
	}

	/**
	 * Find the coordinate of the shape
	 * 
	 * @return Point
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * Finds the area of the shape
	 * 
	 * @return Area
	 */
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * Find if the given point is enclosed inside the shape
	 * 
	 * @return true if the given point is enclosed, else return false
	 */
	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		return (distanceBtwTwoPoints(givenPoint, origin) >= radius);

	}

}
