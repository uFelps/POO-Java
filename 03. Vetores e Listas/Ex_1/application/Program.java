package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rent;

public class Program {
	public static void main(String[] args) {

		// configs
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// criação do vetor que representara os quartos, guardando objetos do tipo
		// Aluguel(cliente).
		Rent[] rooms = new Rent[10];

		// perguntando quantos quartos serão alugados
		System.out.print("How many rooms will be rented? ");
		int roomsQuantity = sc.nextInt();

		// lendo os dados e instanciando a quantidade de objetos que foram definidos
		// acima
		for (int i = 0; i < roomsQuantity; i++) {

			System.out.println();
			System.out.printf("Rent #%d:", i + 1);

			sc.nextLine();

			System.out.print("\\nName: ");
			String name = sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			System.out.print("Room: ");
			int room = sc.nextInt();

			// instanciando o objeto conforme os dados passados acima
			rooms[room] = new Rent(name, email, room);
		}

		System.out.println("\\nBusy Rooms:");

		// laço para apresentar os quartos ocupados
		// irá percorrer todos os quartos

		for (int i = 0; i < rooms.length; i++) {
			// caso não esteja vazio
			if (rooms[i] != null) {

				// apresente
				System.out.println(rooms[i]);
			}
		}

		sc.close();
	}
}