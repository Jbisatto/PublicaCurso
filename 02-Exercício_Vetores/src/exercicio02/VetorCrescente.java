package exercicio02;

import javax.swing.JOptionPane;

public class VetorCrescente {

	public static void main(String[] args) {

		int[] v1 = new int[5];
		int numero = 0;

		for (int i = 0; i < v1.length; i++) {
			v1[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero:"));
		}
		
		for (int i = 0; i < v1.length; i++) {
			for (int j = i + 1; j < v1.length; j++) {
				if (v1[j] < v1[i]) {
					int aux = v1[i];
					v1[i] = v1[j];
					v1[j] = aux;
				}
			}
		}
		for (int i = 0; i < v1.length; i++) {
			System.out.println(v1[i]);
		}

	}

}
//Crie um vetor de cinco posi��es e pe�a
//os cinco valores, em seguida exiba esses valores em ordem crescente.