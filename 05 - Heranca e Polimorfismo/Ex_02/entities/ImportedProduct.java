package entities;

public class ImportedProduct extends Product {

	// atributos
	private Double custonsFee;

	// construtores
	public ImportedProduct() {

	}

	public ImportedProduct(String name, Double price, Double custonsFee) {
		super(name, price);
		this.custonsFee = custonsFee;
	}

	
	// get e set
	public Double getCustonsFee() {
		return custonsFee;
	}

	public void setCustonsFee(Double custonsFee) {
		this.custonsFee = custonsFee;
	}
	
	//metodos
	public Double totalPrice() {
		return getPrice() + custonsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sc = new StringBuilder();
		
		sc.append(getName());
		sc.append(" $ ");
		sc.append(String.format("%.2f", totalPrice()));
		sc.append(" (Customs fee: $ ");
		sc.append(String.format("%.2f", getCustonsFee())+ ")");
		
		return sc.toString();
	}
	
	

}
