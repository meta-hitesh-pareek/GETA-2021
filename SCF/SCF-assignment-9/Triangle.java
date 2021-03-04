package GETA2021.SCF.SCFAssignment9;

import java.sql.Timestamp;
import java.util.Date;

public class Triangle implements Shape {
	final String shapeType = Shape.shapeType.Triangle.toString();
	double base, height;
	Point origin, secondPoint,thirdPoint;
	Timestamp timeStamp;

	/**
	 * Constructor to create Triangle
	 * 
	 * @param origin
	 * @param base
	 * @param height
	 */
	Triangle(Point origin, double base, double height) {
		this.base = base;
		this.height = height;
		this.timeStamp = new Timestamp(new Date().getTime());
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
		return Math.sqrt((this.base * this.base) + (this.height * this.height));
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
		return 0.5 * this.base * this.height;
	}

	/**
	 * Find if the given point is enclosed inside the shape
	 * 
	 * @return true if the given point is enclosed, else return false
	 */
	@Override
	public boolean isPointEnclosed(Point givenPoint) {
        Point p1=origin;
        Point p2=secondPoint;
        Point p3=thirdPoint;
        double d1 =sign(givenPoint,p1,p3),d2=sign(givenPoint,p2,p3),d3=sign(givenPoint,p3,p1);
       
        boolean has_neg = (d1<0) || (d2<0) || (d3<0);
        boolean has_pos =   (d1>0) || (d2>0) || (d3>0);
		
        return (has_neg && has_pos);
	}
	
	private double sign(Point p1,Point p2,Point p3) {
		return (p1.xCoordinate - p3.xCoordinate)
				*(p2.yCoordinate-p3.yCoordinate)
				-(p2.xCoordinate -p3.xCoordinate)
				*(p1.yCoordinate - p3.yCoordinate);
	}

}
