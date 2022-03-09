package Escolha;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		// Variavel para obter a cidade
		String cidade = JOptionPane.showInputDialog("Digite a Cidade: ");
//		switch (cidade.toLowerCase()) {
//		case "blumenau": 
//			JOptionPane.showMessageDialog(null, "Cidade da OckobertFest");
//			break;
//		case "luis alves": 
//			JOptionPane.showMessageDialog(null, "Terra da banana");
//			break;
//		default:
//			JOptionPane.showMessageDialog(null,"Cidade não encontrada");
//		}
		switch (cidade.toLowerCase()) {
		case "blumenau", "indaial", "pomerode"-> JOptionPane.showMessageDialog(null, "SC");
		case "curitiba", "cascavel", "londrina"-> JOptionPane.showMessageDialog(null, "PR");
		default->JOptionPane.showMessageDialog(null, "Não encoontrado!");
		}
	}

}
