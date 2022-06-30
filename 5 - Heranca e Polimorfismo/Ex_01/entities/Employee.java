package entities;

public class Employee {

	// atributos
	private String name;
	private Integer hours;
	private Double valuePerHour;

	// construtores
	public Employee() {

	}

	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	// get e set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	// metodos
	public Double payment() {
		return valuePerHour * hours;
	}
	
	public String toString() {
		StringBuilder sc = new StringBuilder();
		
		sc.append(getName());
		sc.append(" - $ ");
		sc.append(payment());
		
		return sc.toString();
	}

}
