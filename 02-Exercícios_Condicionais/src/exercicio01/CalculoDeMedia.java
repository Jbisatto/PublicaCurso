package exercicio01;

import javax.swing.JOptionPane;

public class CalculoDeMedia {

	public static void main(String[] args) {

		double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a primeira nota:"));
		double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a segunda nota:"));
		double nota3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a terceira nota:"));
		double media = (nota1 + nota2 + nota3) / 3;

		JOptionPane.showConfirmDialog(null, "A m�diad � :" + media);

	}

}
