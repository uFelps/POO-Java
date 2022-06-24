package entities;

public class OrderItem {
	
	//atributos
	private Integer quantity;
	private Double price;
	
	//associações
	private Product product;
	
	
	//construtores
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	
	//get e set
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	//metodos
	public Double subTotal() {
		return quantity * price;
	}
	
	

}
