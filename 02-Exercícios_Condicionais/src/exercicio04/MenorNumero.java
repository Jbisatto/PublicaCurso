package exercicio04;

import javax.swing.JOptionPane;

public class MenorNumero {

	public static void main(String[] args) {
		double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro numero:"));
		double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o segundo numero:"));
		double numero3 = Double.parseDouble(JOptionPane.showInputDialog("Informe o terceiro numero:"));
		
		if(numero1<numero2&&numero1<numero3) {
			JOptionPane.showMessageDialog(null,"O menor numero é: " +numero1);
		}else	if(numero2<numero1&&numero2<numero3) {
			JOptionPane.showMessageDialog(null,"O menor numero é: " +numero2);
		}else if(numero3<numero1&&numero3<numero2) {
			JOptionPane.showMessageDialog(null,"O menor numero é: " +numero3);
		}else {
			JOptionPane.showMessageDialog(null,"Vc digitou numeros iguais");
		}
		

	}

}
