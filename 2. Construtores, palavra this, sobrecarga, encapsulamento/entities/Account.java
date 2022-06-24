package entities;

public class Account {
	
	private static final double taxa = 5.00;
	
	private int accountNumber;
	private String name;
	private double balance;
	
	//Construtores
	public Account(int accountNumber, String name, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.name = name;
		deposito(initialDeposit);
	}
	
	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}
	
	//Getters e Setters
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//Métodos
	public void deposito(double valor) {
		balance += valor;
	}
	
	public void saque(double valor) {
		balance -= (valor + taxa);
	}
	
	public String toString() {
		return "Account "
			+ accountNumber
			+ ", Holder: "
			+ name
			+ ", Balance: $ "
			+ String.format("%.2f", balance);
	}
	
}
