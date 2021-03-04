package GETA2021.SCF.SCFAssignment9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestCasesForScreenClass {

	Screen screen = new Screen(200.0, 200.0);

	@Test
	public void test_When_NewShapeIsAdded_Expected_True() {
		List<Double> listOfPerameters = new ArrayList<Double>();
		double side = 4.0;
		listOfPerameters.add(side);
		String type = "Square";
		Point coordinates = new Point(2, 2);

		Shape createdShape = ShapeFactory.createShape(type, coordinates,
				listOfPerameters);
		boolean result = screen.addShape(createdShape);

		assertTrue(result);
	}

	@Test
	public void test_When_ShapeOfSpecificTypeDeleted_Expected_True() {
		List<Double> listOfPerameters = new ArrayList<Double>();
		double radius = 4.0;
		listOfPerameters.add(radius);
		String type = "Circle";
		Point coordinates = new Point(2, 2);

		Shape createdShape = ShapeFactory.createShape(type, coordinates,
				listOfPerameters);
		screen.addShape(createdShape);
		boolean result = screen.deleteSpecificShape("Circle");

		assertTrue(result);
	}

	@Test
	public void test_when_ShapesAreSortedBasedOnArea_Expected_List() {
		
		/*
		 * Here we are adding two different shapes and sorting based on the area
		 * We expect that the List returned is not empty
		 */
		List<Double> listOfPerametersForFirstShape = new  ArrayList<Double>();
		double radius = 4.0;
		listOfPerametersForFirstShape.add(radius);
		String type = "Circle";
		Point coordinatesForCircle = new Point(40, 20);

		Shape createdCircle = ShapeFactory.createShape(type,coordinatesForCircle, listOfPerametersForFirstShape);
		screen.addShape(createdCircle);

		List<Double> listOfPerametersForSecondShape = new ArrayList<Double>();
		double side = 4.0;
		listOfPerametersForSecondShape.add(side);
		String typeOf = "Square";
		Point coordinatesForSquare = new Point(60, 40);

		Shape createdSquare = ShapeFactory.createShape(typeOf,coordinatesForSquare, listOfPerametersForSecondShape);
		screen.addShape(createdCircle);
		screen.addShape(createdSquare);

		List<Shape> sortedList = screen.sortShapesByArea();

		assertNotNull(sortedList);
	}
}
