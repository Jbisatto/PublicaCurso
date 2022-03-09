package exercicio07;

import javax.swing.JOptionPane;

public class Investimento {

	public static void main(String[] args) {

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor que deseja investir"));
		double taxa = (Double.parseDouble(JOptionPane.showInputDialog("Informe o a taxa de investimento"))) / 100;
		int tempo = Integer.parseInt(JOptionPane.showInputDialog("Tempo de investimento"));

		for (int i = 1; i <= tempo; i++) {
			System.out
					.println("Mês " + i + " -- Ganhos R$" + (valor * taxa) + " -- Total R$" + (valor + (valor * taxa)));
			valor = valor + (valor * taxa);
		}

	}

}
