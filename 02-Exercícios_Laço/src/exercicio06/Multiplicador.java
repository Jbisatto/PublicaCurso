package exercicio06;

import javax.swing.JOptionPane;

public class Multiplicador {

	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		int multiplicador=numero;
		for(int i=numero;i>1;i--) {
			System.out.println(multiplicador+" x "+(i-1)+" = "+multiplicador*(i-1));
			multiplicador=multiplicador*(i-1);
		}

	}

}