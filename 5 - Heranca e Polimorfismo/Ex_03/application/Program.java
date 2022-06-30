package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import enums.Color;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Shape> shapes = new ArrayList<>();

		System.out.print("Enter the number of shapes:");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.printf("Shape #%d data: ", (1 + i));

			System.out.print("Rectangle or Circle (r/c)? ");
			char shapeType = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.nextLine());

			if (shapeType == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();

				System.out.print("Height: ");
				double height = sc.nextDouble();
				sc.nextLine();

				Shape shape = new Rectangle(color, width, height);
				shapes.add(shape);
			}

			else if (shapeType == 'c') {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();

				Shape shape = new Circle(color, radius);
				shapes.add(shape);
			}

		}

		System.out.println();
		System.out.println("SHAPES AREA:");
		for(Shape shape : shapes) {
			System.out.printf("%.2f", shape.area());
		}

		sc.close();
	}

}
