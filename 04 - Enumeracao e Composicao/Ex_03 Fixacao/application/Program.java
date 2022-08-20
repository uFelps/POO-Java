package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//cliente
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();	
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String data = sc.nextLine();
		
		Client client = new Client(name, email, sdf.parse(data));
		System.out.println();
		
		
		//pedido
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		
		//Itens do pedido
		System.out.print("How many itens to this order? ");
		int qtdItens = sc.nextInt();
		sc.nextLine();
		
		
		for(int i=0; i<qtdItens; i++) {
			System.out.printf("%nEnter #%d item data:", (i+1));
			
			System.out.print("\nProduct name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, price);
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		
		sc.close();
	}

}
