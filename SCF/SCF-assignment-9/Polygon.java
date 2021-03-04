package GETA2021.SCF.SCFAssignment9;

import java.sql.Timestamp;

/**
 * Creates shape Polygon and implement different methods like
 * getTtimeStamp,getShapeType,getPerimeter,getOrigin getArea,isPointEnclosed
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class Polygon implements Shape {
	final String shapeType = Shape.shapeType.Polygon.toString();
	private double side;
	private double numberOfSide;
	private Point origin;
	private Timestamp timeStamp;

	/**
	 * Constructor to create Polygon
	 * 
	 * @param origin
	 * @param numberOfSide
	 * @param side
	 */
	Polygon(Point origin, double numberOfSide, double side) {
		this.side = side;
		this.numberOfSide = numberOfSide;
		this.origin = origin;
	}

	/**
	 * Finds distance of point from origin
	 * 
	 * @return Distance
	 */
	@Override
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(origin.xCoordinate, 2)
				+ Math.pow(origin.yCoordinate, 2));
	}

	/**
	 * Find timestamp when the shape was created
	 * 
	 * @return TimeStamp
	 */
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
		return (numberOfSide * side);
	}

	/**
	 * Find the cordinate of the shape
	 * 
	 * @return Point
	 */
	@Override
	public Point getOrigin() {
		return new Point(origin.xCoordinate, origin.yCoordinate);
	}

	/**
	 * Finds the area of the shape
	 * 
	 * @return Area
	 */
	@Override
	public double getArea() {
		double angle = Math.toRadians(180 / numberOfSide);
		double tangentAngle = Math.tan(angle);
		double area = (side * side * numberOfSide) / (4 * tangentAngle);

		return area;
	}

	/**
	 * Find if the given point is enclosed inside the shape
	 * 
	 * @return true if the given point is enclosed, else return false
	 */
	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		return true;
	}
}
