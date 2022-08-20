package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date manufactureDate;

	// construtores
	public UsedProduct() {

	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	// get e set
	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	
	//metodos
	@Override
	public String priceTag() {
		StringBuilder sc = new StringBuilder();
		
		sc.append(getName());
		sc.append(" (used) $ ");
		sc.append(String.format("%.2f", getPrice()));
		sc.append(" (Manufacture date: ");
		sc.append(sdf.format(getManufactureDate()));
		sc.append(")");
		
		return sc.toString();
	}
}
