package application;

import java.util.Scanner;

import model.entities.PrintService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrintService<Integer> ps = new PrintService<>();
		
		System.out.print("How many values? ");
		int n = sc.nextInt();
		
		for(int i=0; i < n; i++) {
			ps.addValue(sc.nextInt());
		}
		
		ps.print();
		System.out.println("First: " + ps.first());
		
		
		sc.close();

	}

}
