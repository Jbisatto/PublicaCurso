package exercicio07;

public class Matriz25posicoes {

	public static void main(String[] args) {
		int[][] matriz = new int[5][5];
		int contador = 1, soma = 0,qtdAcimaMedia=0;

//Preenchimeto da matriz		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = contador;
				contador++;

			}

		}

//Exibir matriz
		for (int i = 0; i < 5; i++) {
			System.out.println("");
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j] + "  ");
			}

		}
//Somar valores matriz		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				soma += matriz[i][j];

			}

		}
		System.out.println("\nSoma Total:" + soma);
		System.out.println("Diagonal secund�ria");
//Diagonal Principal		
		for (int i = 0; i < 5; i++) {
			for (int j = i; j == i; j++) {
				System.out.print(matriz[i][j] + "  ");

			}

		}
		System.out.println("");
		System.out.println("Diagonal secund�ria");
// Diagonal Secundaria
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j<5; j++) {
				if(i+j==4) {
				System.out.print(matriz[i][j] + "  ");
				}
			}

		}
//		Media dos valores cadastrados
		
		System.out.println("\nMedia do valores cadastrados :" + (soma/25));
		
//		Quantidade de n�meros que s�o maiores ou iguais a m�dia		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(matriz[i][j]>=(soma/25)) {
					qtdAcimaMedia++;
				}

			}

		}
		System.out.println("\nQuantidade de n�meros que s�o maiores ou iguais a m�dia :" + qtdAcimaMedia);

	}

}
