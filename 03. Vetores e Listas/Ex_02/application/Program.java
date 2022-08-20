package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// criando uma lista do tipo Employee para armazenar registros de funcionarios
		List<Employee> funcionarios = new ArrayList<>();

		// verificando quantos funcionarios serão registrados
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		// laço para receber o registro de cada usuário
		for (int i = 0; i < n; i++) {

			System.out.println();
			System.out.println("Employee #" + (i + 1));

			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			// adicionando um registro na lista
			funcionarios.add(new Employee(id, name, salary));

		}

		System.out.println();
		// peguntando qual funcionario tera o acressimo
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();

		// funcReajuste passa a apontar para o objeto que essa expressão retornar
		Employee funcReajuste = funcionarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		// se o funcionario escolhido for diferente de null
		if (funcReajuste != null) {

			// entrada da porcentagem
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();

			// reajuste
			funcReajuste.increaseSalary(percentage);

		} else {// se não..
			System.out.println("This id does not exist!");
		}

		// saida dos registros
		System.out.println();
		System.out.println("List of Employees");
		for (Employee funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		sc.close();
	}
}