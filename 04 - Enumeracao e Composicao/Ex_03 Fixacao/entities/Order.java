package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	// atributos
	private Date moment;
	private OrderStatus status;

	// associações
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();

	// construtores
	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	
	//get e set
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	
	//metodos
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		Double sum = 0.0;
	
		for(OrderItem item: itens) {
			sum += item.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " ");
		sb.append("(" + sdf.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		
		for(OrderItem item : itens) {
			sb.append(item.getProduct().getName() + ", $");
			sb.append(item.getProduct().getPrice());
			sb.append(", Quantity: ");
			sb.append(item.getQuantity());
			sb.append(", Subtotal: $");
			sb.append(item.subTotal() + "\n");
		}
		
		sb.append("Total price: $");
		sb.append(total());
		
		return sb.toString();
	}
}
