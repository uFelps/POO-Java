package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				
				products.add(new Product(name, price));
				
				line = br.readLine();
			}
			
			
			double avg = products.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / products.size();
			
			System.out.println("Average price: "+ avg);
			
			
			Comparator<String> comp = (p1, p2) -> p1.compareTo(p2);
			
			List<String> names = products.stream()
					.filter(p -> p.getPrice() < avg)
					.map(p -> p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
					
			
			
			names.forEach(System.out::println);
			
			
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}
}
