package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		Employee funcionario = new Employee();
	
		//Entrada dos dados do funcionario
		System.out.print("Nome: ");
		funcionario.name = sc.nextLine();
		System.out.print("Gross Salary: ");
		funcionario.grossSalary = sc.nextDouble();
		System.out.print("Tax: ");
		funcionario.tax = sc.nextDouble();
	
		//Apresentação dos dados do funcionario
		System.out.println("\nEmployee: " + funcionario);
	
		//Entrada da porcentagem para o salario
		System.out.print("\nWhich percentage to increase salary? ");
		double percentage = sc.nextDouble();
		funcionario.increaseSalary(percentage);
	
		//Apresentação dos dados do funcionario
		System.out.println("\nUpdated data: " + funcionario);
	
	
		sc.close();
	}
}