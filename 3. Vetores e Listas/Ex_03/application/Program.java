package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] matriz = new int[m][n];

		/// entrada da matriz
		for (int i = 0; i < m; i++) {/// linhas
			for (int j = 0; j < n; j++) {// coluna
				matriz[i][j] = sc.nextInt();
			}
		}

		System.out.println();
		int x = sc.nextInt();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matriz[i][j] == x) {
					System.out.printf("Position %d,%d%n", i, j);

					// esquerda
					if (j > 0) {/// significa q tem posição a esquerda
						System.out.println("Left: " + matriz[i][j - 1]);
					}

					// top
					if (i > 0) {/// significa q tem posição acima
						System.out.println("Up: " + matriz[i - 1][j]);
					}

					// right
					if (j < (n - 1)) {/// significa q tem posição a direita
						System.out.println("Right: " + matriz[i][j + 1]);
					}

					// top
					if (i < (m - 1)) {/// significa q tem posição abaixo
						System.out.println("Dowm: " + matriz[i + 1][j]);
					}

				}
			}
		}
		sc.close();
	}
}