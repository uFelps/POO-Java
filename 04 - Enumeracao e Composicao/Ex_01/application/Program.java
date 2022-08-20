package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enumeradas.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		//departamento
		System.out.print("Enter departament's name: ");
		String depto = sc.nextLine();
		
		//worker
		System.out.println("\nEnter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: " );
		String level = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(depto));
		
		//contracts
		System.out.print("How many contracts to this worker? ");
		int numContracts = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i < numContracts; i++) {
			System.out.printf("%nEnter contract #%d data: %n", (i+1));
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.nextLine());
			
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			sc.nextLine();
			
			worker.addContract(new HourContract(date, valuePerHour, hours));
		}
		
		
		System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
		String data = sc.next();
		
		int month = Integer.parseInt(data.substring(0,2));
		int year = Integer.parseInt(data.substring(3));
		
		
		System.out.printf("Name: %s", worker.getName());
		System.out.print("\nDepartament: " + worker.getDepartament());
		System.out.printf("%nIncome for %s: %.2f", data, worker.income(year, month));
		
				
		
		sc.close();
	}

}
