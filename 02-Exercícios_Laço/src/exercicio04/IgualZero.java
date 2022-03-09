package exercicio04;

import javax.swing.JOptionPane;

public class IgualZero {

	public static void main(String[] args) {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero(Para finalizar digite 0"));
		int soma=numero;
		while(numero!=0) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero(Para finalizar digite 0"));
			soma=soma+numero;
		}

		JOptionPane.showMessageDialog(null,"A soma final é "+soma);
	}

}
