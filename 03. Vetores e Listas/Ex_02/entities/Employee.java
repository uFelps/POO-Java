package entities;

public class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// get e set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	// metodos
	public void increaseSalary(double percentage) {
		double porcentagem = (salary * percentage) / 100;

		salary += porcentagem;
	}

	public String toString() {
		return id + ", " + name + ", $ " + String.format("%.2f", salary);
	}
}