package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		
		List<String> newlist = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		newlist.forEach(System.out::println);
		
		
		for(Product p : list) {
			System.out.println(p);
		}
	}

}
