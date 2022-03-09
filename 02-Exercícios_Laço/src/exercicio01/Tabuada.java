package exercicio01;

import javax.swing.JOptionPane;

public class Tabuada {

	public static void main(String[] args) {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		for (int i=0;i<11;i++) {
			System.out.println(i+" x "+numero+" = "+numero*i);
		}

	}

}
