package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourContract {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//atributos
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	
	//construtores
	HourContract(){
		
	}
	
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	
	//get e set
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	
	//metodos
	public Double totalValue() {
		return valuePerHour * hours;
	}

	@Override
	public String toString() {
		return "\nContract: [ Date: " + sdf.format(date) + ", valuePerHour: " + valuePerHour + ", hours: " + hours + "]";
	}
	
	
}
