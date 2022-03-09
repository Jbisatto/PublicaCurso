package exercicio07;

import javax.swing.JOptionPane;

public class PositivoNegativo {

	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número"));
		if(numero>=0) {

			JOptionPane.showMessageDialog(null,"Positivo");
		}else {


			JOptionPane.showMessageDialog(null,"Negativo");
		}
	}

}
