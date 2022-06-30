package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> pessoas = new ArrayList<>();
		
		System.out.print("Informe o número de pessoas: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.printf("Dados Pessoa #%d:%n", (i+1));
			
			System.out.print("Física ou Júridica (f/j)? ");
			char tipoPessoa = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			sc.nextLine();
			
			
			if(tipoPessoa == 'f') {
				System.out.print("Gastos com Saúde: ");
				double gastoSaude = sc.nextDouble();
				
				Pessoa pessoa = new PessoaFisica(nome, rendaAnual, gastoSaude);
				pessoas.add(pessoa);
			}
			
			else if(tipoPessoa == 'j') {
				System.out.print("Número de funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				
				Pessoa pessoa = new PessoaJuridica(nome, rendaAnual, numeroFuncionarios);
				pessoas.add(pessoa);
			}
		}
		
		System.out.println();
		System.out.println("Impostos de Renda: ");
		
		double totalTaxa = 0.0;
		
		for(Pessoa pessoa : pessoas) {
			totalTaxa += pessoa.calcularImposto();
			System.out.println(pessoa.getNome() + ": $ " + String.format("%.2f", pessoa.calcularImposto()));
		}
		
		System.out.println("TOTAL TAXA: $" + String.format("%.2f", totalTaxa));

		sc.close();
	}
}
