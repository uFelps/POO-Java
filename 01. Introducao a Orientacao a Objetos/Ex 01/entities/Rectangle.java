package entities;

public class Rectangle {
	
	//atributos
	public double width;
	public double height;
	
	//metodos
	public double area() {
		return width * height;
	}

	public double perimeter() {
		return (2 * (width + height));
	}
	
	public double diagonal() {
		double x = Math.pow(width, 2);
		double y = Math.pow(height, 2);
		double soma = x + y;
		double total = Math.sqrt(soma);
		return total;
	}
	
	public String toString() {
		return "AREA = "
			+ String.format("%.2f", area())
			+ "\nPERIMETER = "
			+ String.format("%.2f", perimeter())
			+ "\nDIAGONAL = "
			+ String.format("%.2f", diagonal());
	}
}
