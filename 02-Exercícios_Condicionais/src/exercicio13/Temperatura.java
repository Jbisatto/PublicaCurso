package exercicio13;

import javax.swing.JOptionPane;

public class Temperatura {

	public static void main(String[] args) {
		double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Informe a Temperatura:"));
		int converte = Integer.parseInt(
				JOptionPane.showInputDialog("" + "1-Celsius para Fahrenheit" + " \n2-Fahrenheitr para Celsius"));
		if (converte == 1) {
			temperatura = (temperatura*1.8) +32;
			JOptionPane.showMessageDialog(null, "A temperatura em Fahrenheit é " + temperatura);

		} else {
			temperatura = (temperatura - 32) / 1.8;
			JOptionPane.showMessageDialog(null, "A temperatura em Celsius é " + temperatura);

		}

	}
}
