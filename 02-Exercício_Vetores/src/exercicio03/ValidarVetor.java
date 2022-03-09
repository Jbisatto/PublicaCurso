package exercicio03;

import javax.swing.JOptionPane;

public class ValidarVetor {

	public static void main(String[] args) {
		int[] v1 = new int[10];
		int numero, contador = 0;

		while (contador < 10) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero: " + contador));
			boolean repetido = false;
			for (int i = 0; i < v1.length; i++) {
				if (numero == v1[i]) {
					repetido=true;
					System.out.println("repetido");
				}
			}
			if(repetido==false) {
				v1[contador]=numero;
				contador++;
			}
		}

		for (int i = 0; i < v1.length; i++) {
			System.out.println(v1[i]);
		}

	}

}
