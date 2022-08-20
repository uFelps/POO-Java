package entities;

public class Employee {
	
	public String name;
	public double grossSalary;
	public double tax;
	
	public double netSalary() {
		return grossSalary - tax;
	}
	
	public void increaseSalary(double percentage) {
		double porcentagem = (grossSalary * percentage)/100;
		grossSalary += porcentagem;
	}
	
	public String toString() {
		return name
			+ ", $ "
			+ String.format("%.2f", netSalary());
	}
}