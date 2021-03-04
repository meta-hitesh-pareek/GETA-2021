package GETA2021.SCF.SCFAssignment9;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Create objects for classes like
 * Shape,Rectangle,Circle,Square,Polygon,Triangle according to given
 * specification
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public abstract class ShapeFactory implements Shape {
	shapeType type;
	Point origin;
	Timestamp timeStamp;
	Date d = new Date();
	List<Double> listOfParmeters;

	
	/**
	 * Create specific shape according to given parameters
	 * 
	 * @param shapeType of the shape to be drawn
	 * @param origin where the shape is to be drawn on screen
	 * @param listOfParameters
	 * @return Shape object
	 * @throws IllegalArgumentException if arguments passed for specific shape are not enough or illegal
	 * @throws NullPointer Exception if null value is passed in the arguments
	 */
	public static Shape createShape(String shapeType, Point origin,
			List<Double> listOfParameters) throws IllegalArgumentException {
		Shape shape = null;
		
		if (origin.xCoordinate < 0 || origin.yCoordinate < 0) {
			throw new IllegalArgumentException();
		}
		
		if (shapeType == null || origin == null || listOfParameters.size() == 0) {
			throw new NullPointerException();
		}
		
		switch (shapeType) {
			case "Circle":
			if (listOfParameters.size() == 1) {
				shape = new Circle(origin, listOfParameters.get(0));
			}
			break;
		case "Rectangle":
			if (listOfParameters.size() == 2) {
				shape = new Rectangle(origin, listOfParameters.get(0),
						listOfParameters.get(1));
			}
			break;
		case "Triangle":
			if (listOfParameters.size() == 2) {
				shape = new Triangle(origin, listOfParameters.get(0),
						listOfParameters.get(1));
			}
			break;
		case "Square":
			if (listOfParameters.size() == 1) {
				shape = new Square(origin, listOfParameters.get(0));
			}
			break;

		case "Polygon":
			if (listOfParameters.size() == 2) {
				shape = new Polygon(origin, listOfParameters.get(0),
						listOfParameters.get(1));
			}
			break;
		default:
			throw new IllegalArgumentException();
		}
		return shape;
	}
}
