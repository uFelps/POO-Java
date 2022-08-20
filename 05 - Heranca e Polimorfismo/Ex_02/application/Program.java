package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i < n; i++) {
			System.out.printf("Product #%d data:%n", (i+1));
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			
			if(productType == 'c') {
				
				Product product = new Product(name, price);
				products.add(product);
			}
			
			else if(productType == 'u') {
				
				System.out.print("Manufacture date: (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.nextLine());
				
				Product product = new UsedProduct(name, price, manufactureDate);
				products.add(product);
			}
			
			else if(productType == 'i') {
				
				System.out.print("Custons fee: ");
				double custonsFee = sc.nextDouble();
				
				Product product = new ImportedProduct(name, price, custonsFee);
				products.add(product);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product product : products) {
			System.out.println(product.priceTag());
		}
			
		sc.close();
	}

}
