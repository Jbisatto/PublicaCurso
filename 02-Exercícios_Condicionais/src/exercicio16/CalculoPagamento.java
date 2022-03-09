package exercicio16;

import javax.swing.JOptionPane;

public class CalculoPagamento {

	public static void main(String[] args) {
		
		double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor ganho por hora:"));
		double qtdHorasNormal = Double.parseDouble(JOptionPane.showInputDialog("Informe a quatidade de horas normal:"));
		double qtdHoras50 = Double.parseDouble(JOptionPane.showInputDialog("Informe a quatidade de horas extras com 50%:"));
		double qtdHoras100 = Double.parseDouble(JOptionPane.showInputDialog("Informe a quatidade de horas extras com 100%:"));
		double salario = (valorHora*qtdHorasNormal)+((valorHora*qtdHoras50)*1.5)+((valorHora*qtdHoras100)*2);
		

		JOptionPane.showMessageDialog(null, "Salário: "+salario);
	}

}
