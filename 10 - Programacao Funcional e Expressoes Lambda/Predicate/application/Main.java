package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 10.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		
		list.removeIf(p -> p.getPrice() < 100.00);
		
		
		for(Product p : list) {
			System.out.println(p);
		}
	}

}
