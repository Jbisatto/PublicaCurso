package exercicio10;

import javax.swing.JOptionPane;

public class SeparadorNumeros {

	public static void main(String[] args) {
		int pares = 0, impares = 0, positivos = 0, negativos = 0, qtdnumero = 0, numero;
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero ou 0 para encerrrar!!!"));
			qtdnumero++;
			if (numero % 2 == 0) {
				pares++;
			} else {
				impares++;
			}
			if (numero < 0) {
				negativos++;
			}
			if (numero > 0) {
				positivos++;
			}
		} while (numero != 0);
		JOptionPane.showMessageDialog(null,
				"Quantidade de numeros informada: " + qtdnumero + "\nNumeros pares: " + pares + "\nNumeros impares: "
						+ impares + "\nNumeros positivos: " + positivos + "\nNumeros negativos: " + negativos);
	}

}
