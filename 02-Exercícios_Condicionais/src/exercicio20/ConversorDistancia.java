package exercicio20;

import javax.swing.JOptionPane;

public class ConversorDistancia {

	public static void main(String[] args) {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor que deseja converter"));
		int converte = Integer.parseInt(JOptionPane.showInputDialog(""
				+ "1- Milhas para Quilômetros"
				+ " \n 2-Quilômetros para milhas"));
		switch (converte) {
		case 1: 
			valor= valor*1.609344;

			JOptionPane.showMessageDialog(null,"Milhas(mi) "+valor);
			break;
		case 2: 
			valor= valor*0.6214;
			JOptionPane.showMessageDialog(null,"Quilomêtros(Km) "+valor);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Informação incorreta!!!");
		}

	}

}
