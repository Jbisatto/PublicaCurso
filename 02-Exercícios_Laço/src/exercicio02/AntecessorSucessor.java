package exercicio02;

import javax.swing.JOptionPane;

public class AntecessorSucessor {

	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		System.out.println("Antecessor de "+numero);
		for (int i=numero;i>(numero-11);i--) {
			System.out.println(i-1);
		}
		System.out.println("Sucessor de "+numero);
		for (int i=numero;i<(numero+11);i++) {
			System.out.println(i+1);
		}
	}

}
