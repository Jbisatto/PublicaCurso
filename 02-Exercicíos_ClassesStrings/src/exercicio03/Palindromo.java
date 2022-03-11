package exercicio03;

import javax.swing.JOptionPane;

public class Palindromo {

	public static void main(String[] args) {

		String verbo = JOptionPane.showInputDialog("Informe uma frase");
		boolean palindromo=true;
		int aux=verbo.length()-1;
		for (int i = 0; i < verbo.length(); i++) {
				if (verbo.charAt(i)!=verbo.charAt(aux)) {
					palindromo = false;
					break;
				}
			aux--;
		}
		if(palindromo) {
			palindromo=true;
			JOptionPane.showMessageDialog(null, "É um palindromo");
		}else {
			JOptionPane.showMessageDialog(null, "Não é um palindromo");
		}

	}

}
