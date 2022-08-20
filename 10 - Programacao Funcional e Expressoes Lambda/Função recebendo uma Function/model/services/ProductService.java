package model.services;

import java.util.List;
import java.util.function.Predicate;

import model.entities.Product;

public class ProductService {
	
	public double filteredSum(List<Product> list, Predicate<Product> predicate) {
		double sum = 0.0;
		
		for(Product p : list) {
			if(predicate.test(p)) {
				sum += p.getPrice();
			}
		}
		
		
		return sum;
	}

}
