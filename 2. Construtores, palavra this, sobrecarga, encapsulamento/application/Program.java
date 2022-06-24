package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Account usuario;
		
		//Entrada do numero da conta e do nome
		System.out.print("Enter account number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter account holder: ");
		String name = sc.nextLine();
		
		//Pergunta se existe deposito inicial
		System.out.print("Is there na initial deposit (y/n)? ");
		char question = sc.next().charAt(0);
		
		
		//caso a resposta seja sim
		if(question == 'y') {
			System.out.print("Enter initial deposit value: ");//entrada para o deposito
			double initialDeposit = sc.nextDouble();
			
			usuario = new Account(accountNumber, name, initialDeposit);//instancia o objeto já com o deposito
			
		} else {//se nao
			usuario = new Account(accountNumber, name);//instancia o objeto sem o deposito
			
		}
		
		
		//Mostra os dados da conta
		System.out.printf("%nAccount data: %n%s%n", usuario);
		
		
		//Entrada de um depósito
		System.out.print("\nEnter a deposit value: ");
		double depositValue = sc.nextDouble();
		usuario.deposito(depositValue);
		
		//Mostra os dados atualizados
		System.out.printf("Updated account data: %n%s%n", usuario);
		
		
		//Entrada de um saque
		System.out.print("\nEnter a withdraw value: ");
		double valorSaque = sc.nextDouble();
		usuario.saque(valorSaque);
		
		//Mostra os dados atualizados
		System.out.printf("Updated account data: %n%s%n", usuario);
		
		
		sc.close();
	}

}
