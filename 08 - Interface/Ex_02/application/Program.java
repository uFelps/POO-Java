package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		
		System.out.print("Contract Value: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, contractValue);
		
		System.out.print("number of installments: ");
		int installments = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processInstallments(contract, installments);
		
		System.out.println("Installments:");
		for(Installment installment : contract.getInstallments()) {
			System.out.println(sdf.format(installment.getDueDate()) + " - " + installment.getAmount());
		}
		
		
		
		
		sc.close();
	}

}
