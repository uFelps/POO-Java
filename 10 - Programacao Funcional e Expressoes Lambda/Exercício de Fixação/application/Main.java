package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
 		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				String name = fields[0];
				String email = fields[1];
				Double salary = Double.parseDouble(fields[2]);
				
				employees.add(new Employee(name, email, salary));
				
				line = br.readLine();
			}
			
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			
			
			Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);
			
			List<String> emails = employees.stream()
					.filter(p -> p.getSalary() > salary)
					.map(p -> p.getEmail())
					.sorted(comp)
					.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
			
			
			double sum = employees.stream().filter(p -> p.getName().charAt(0) == 'M').map(p -> p.getSalary()).reduce(0.0, (x,y) -> x + y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + sum);
					
			
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		sc.close();
	}

}
