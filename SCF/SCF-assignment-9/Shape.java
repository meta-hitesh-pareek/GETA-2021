package GETA2021.SCF.SCFAssignment9;

import java.sql.Timestamp;

/**
 * Interface to declare functions for classes which implements Shape
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public interface Shape {

	String getShapeType();

	double getPerimeter();

	double getArea();

	boolean isPointEnclosed(Point point);

	Point getOrigin();

	Timestamp getTimeStamp();

	double getOriginDistance();

	static enum shapeType {
		Circle, Triangle, Rectangle, Polygon, Square
	}

}
