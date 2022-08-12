package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;

public class Main {

	public static void main(String[] args) {
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Rectangle(10.0, 5.0));
		shapes.add(new Circle(10.0));
		
		
		List<Circle> circles = new ArrayList<>();
		circles.add(new Circle(10.0));
		circles.add(new Circle(12.0));
		
		
		System.out.println(totalArea(shapes));
		System.out.println(totalArea(circles));
		
	}
	
	public static double totalArea(List<? extends Shape> list) {
		
		double totalArea = 0.0;
		
		for(Shape shape : list) {
			totalArea += shape.area();
		}
		
		return totalArea;
	}

}
