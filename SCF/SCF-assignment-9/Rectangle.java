package GETA2021.SCF.SCFAssignment9;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Creates shape Rectangle and implement different functions like
 * getTtimeStamp,getShapeType,getPerimeter,getOrigin getArea,isPointEnclosed
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class Rectangle implements Shape {
	final String shapeType = Shape.shapeType.Rectangle.toString();
	double length, breadth;
	Point origin;
	Timestamp timeStamp;

	/**
	 * Constructor to create Rectangle
	 * 
	 * @param origin
	 * @param length
	 * @param breadth
	 */
	Rectangle(Point origin, double length, double breadth) {
		this.origin = origin;
		this.length = length;
		this.breadth = breadth;
		this.timeStamp =new Timestamp(new Date().getTime());
	}

	/**
	 * Find timestamp when the shape was created
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
	 * Finds distance of point from origin
	 * 
	 * @return Distance
	 */
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(origin.xCoordinate, 2)
				+ Math.pow(origin.yCoordinate, 2));
	}

	/**
	 * Finds perimeter of the shape
	 * 
	 * @return Perimeter
	 */
	@Override
	public double getPerimeter() {
		return 2 * (length + breadth);
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
		return length * breadth;
	}

	/**
	 * Find the coordinate of bottom right point of rectangle
	 * 
	 * @return Coordinate of bottom right corner
	 */
	private Point getBottomRightCorner() {
		return new Point(origin.xCoordinate + length, origin.yCoordinate);
	}

	/**
	 * Find the coordinate of top left point of rectangle
	 * 
	 * @return Coordinate of top left corner
	 */
	private Point getTopLeftCorner() {
		return new Point(origin.xCoordinate, origin.yCoordinate + breadth);
	}

	/**
	 * Find if the given point is enclosed inside the shape
	 * 
	 * @return true if the given point is enclosed, else return false
	 */
	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		Point bottomRightCorner = getBottomRightCorner();
		Point topLeftCorner = getTopLeftCorner();
		if (givenPoint.xCoordinate > origin.xCoordinate
				&& givenPoint.xCoordinate <= bottomRightCorner.xCoordinate
				&& givenPoint.yCoordinate > origin.yCoordinate
				&& givenPoint.yCoordinate <= topLeftCorner.yCoordinate) {

			return true;
		}
		return false;
	}
}
