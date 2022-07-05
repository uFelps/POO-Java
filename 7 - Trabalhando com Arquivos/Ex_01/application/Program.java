package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.println("Digite o caminho do arquivo:");
		String diretorioArquivo = sc.nextLine();
		File arquivo = new File(diretorioArquivo);
		
		String diretorioPasta = arquivo.getParent();
		
		boolean success = new File(diretorioPasta + "/out").mkdir();
		
		String diretorioNovoArquivo = diretorioPasta + "/out/summary.csv";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] product = line.split(",");
				
				String name = product[0];
				Double price = Double.parseDouble(product[1]);
				Integer quantity = Integer.parseInt(product[2]);
				
				products.add(new Product(name, price, quantity));
				
				line = br.readLine();
			}
			
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(diretorioNovoArquivo))){
				
				for(Product p : products) {
					bw.write(p.getName() + "," + p.total());
					bw.newLine();
				}
			}
			
			catch(IOException e) {
				System.out.println("Erro ao gerar novo arquivo: " + e.getMessage());
			}
		}
		
		catch(IOException e) {
			System.out.println("Erro na Leitura do arquivo: "+ e.getMessage());
		}
		
		
		sc.close();
	}

}
