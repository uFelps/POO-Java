package entities;

import enums.Color;

public class Circle extends Shape {

	//atributos
	private Double radius;
	
	//construtores
	public Circle() {
		super();
	}
	
	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}
	
	// get e set 
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	//metodos
	@Override
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
}
