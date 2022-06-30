package entities;

import enums.Color;

public abstract class Shape {
	
	private Color color;

	
	//construtor
	public Shape() {
		
	}
	
	public Shape(Color color) {
		this.color = color;
	}
	
	// get e set
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	//metodos
	public abstract Double area();
	
	

}
