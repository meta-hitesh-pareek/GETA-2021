package GETA2021.SCF.SCFAssignment9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Stores different shapes create on screen
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class Screen {
    double XMAX;
    double YMAX;
    
    Screen(double XMAX,double YMAX){
    	this.XMAX=XMAX;
    	this.YMAX=YMAX;
    }
	static List<Shape> listOfShapes = new ArrayList<Shape>();

	/**
	 * Add a shape to the screen
	 * 
	 * @param shape to be added
	 * @throws NullPointerException
	 */
	public boolean addShape(Shape shape) throws NullPointerException {
		if (shape == null) {
			throw new NullPointerException();
		}
		listOfShapes.add(shape);
		return true;
	}

	/**
	 * Deletes all shapes of a specific type
	 * 
	 * @param type of the shapes to be removed
	 * @return true if the shapes are successfully deleted from the screen
	 * @throws NullPointerException if the type of the shape passed is null
	 * @throws IllegalArgumentException if the type of the shape passed if empty string
	 */
	public boolean deleteSpecificShape(String type) {
		if(type==null) {
			throw new NullPointerException();
		}
		if("".equals(type)) {
			throw new IllegalArgumentException();
		}
		List<Shape> shapesToDelete = new ArrayList<Shape>();
		for (Shape shape : listOfShapes) {
			if (shape.getShapeType().equals(type)) {
				shapesToDelete.add(shape);
			}
		}
		listOfShapes.removeAll(shapesToDelete);
		return true;
	}
   
	/**
	 * Show all shapes drawn on  the screen
	 */
	public void showShapes() {
		for (Shape shape : listOfShapes) {
			System.out.println(shape.getShapeType());
		}
	}
	
	/**
	 * Finds how many shape on the screen encloses a specific point
	 * 
	 * @param givenCoordinate
	 * @return List of shapes
	 */
	public List<Shape> allShapeEnclosedPoint(Point givenCoordinate){
		List<Shape> finalList=new ArrayList<Shape>();
		for(Shape shape:listOfShapes) {
			if(shape.isPointEnclosed(givenCoordinate)==true) {
				finalList.add(shape);
			}
		}
		return finalList;
	}

	/**
	 * Sort List of shapes according to area in ascending order
	 * @return List of sorted shapes
	 */
	public List<Shape> sortShapesByArea() {
		List<Shape> shapesSortedByArea = new ArrayList<Shape>(listOfShapes);
		Collections.sort(shapesSortedByArea, sortByArea);

		return shapesSortedByArea;
	}

	/**
	 * Sort List of shapes according to time stamp in ascending order
	 * @return List of sorted shapes
	 */
	public List<Shape> sortShapesByTimeStamp() {
		List<Shape> shapesSortedByArea = new ArrayList<Shape>(listOfShapes);
		Collections.sort(shapesSortedByArea, sortByTimeStamp);

		return shapesSortedByArea;
	}

	/**
	 * Sort List of shapes according to perimeter in ascending order
	 * @return List of sorted shapes
	 */
	public List<Shape> sortShapesByPerimeter() {
		List<Shape> shapesSortedByArea = new ArrayList<Shape>(listOfShapes);
		Collections.sort(shapesSortedByArea, sortByPerimeter);

		return shapesSortedByArea;
	}

	/**
	 * Sort List of shapes according to distance from origin in ascending order
	 * @return List of sorted shapes
	 */
	public List<Shape> sortShapesByOriginDistance() {
		List<Shape> shapesSortedByArea = new ArrayList<Shape>(listOfShapes);
		Collections.sort(shapesSortedByArea, sortByOriginDistance);

		return shapesSortedByArea;
	}

	/**
	 *  Custom comparator to sort shapes by area
	 */
	private static Comparator<Shape> sortByArea = new Comparator<Shape>() {
		public int compare(Shape shapeOne, Shape shapeTwo) {
			if (shapeOne.getArea() > shapeTwo.getArea()) {
				return 1;
			} else {
				return -1;
			}
		}
	};

	/**
	 *  Custom comparator to sort shapes by perimeter
	 */
	private static Comparator<Shape> sortByPerimeter = new Comparator<Shape>() {
		public int compare(Shape shapeOne, Shape shapeTwo) {
			if (shapeOne.getPerimeter() > shapeTwo.getPerimeter()) {
				return 1;
			} else {
				return -1;
			}
		}
	};

	/**
	 *  Custom comparator to sort shapes by time stamp
	 */
	private static Comparator<Shape> sortByTimeStamp = new Comparator<Shape>() {
		public int compare(Shape shapeOne, Shape shapeTwo) {
			return (shapeOne.getTimeStamp().compareTo(shapeTwo.getTimeStamp()));
		}
	};

	/**
	 *  Custom comparator to sort shapes by distance from origin
	 */
	private static Comparator<Shape> sortByOriginDistance = new Comparator<Shape>() {
		public int compare(Shape shapeOne, Shape shapeTwo) {
			if (shapeOne.getOriginDistance() > shapeTwo.getOriginDistance()) {
				return 1;
			} else {
				return -1;
			}
		}
	};
}
