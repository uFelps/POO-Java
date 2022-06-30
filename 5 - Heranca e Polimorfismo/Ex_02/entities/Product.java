package entities;

public class Product {
	
	//atributos
	private String name;
	private Double price;
	
	//construtores
	public Product() {
		
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	
	//get e set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//metodos
	public String priceTag() {
		StringBuilder sc = new StringBuilder();
		
		sc.append(getName());
		sc.append(" $ ");
		sc.append(String.format("%.2f", getPrice()));
		
		return sc.toString();
	}

	
	
	
}
