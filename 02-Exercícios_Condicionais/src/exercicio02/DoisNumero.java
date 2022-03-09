package exercicio02;

import javax.swing.JOptionPane;

public class DoisNumero {

	public static void main(String[] args) {
		
	
	double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro numero:"));
	double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o segundo numero:"));
	double resultado;
	
	if(numero1==numero2) {
		resultado=numero1+numero2;
		JOptionPane.showMessageDialog(null, "A soma de "+numero1+" + "+numero2+" = "+resultado);
	}else {
		resultado=numero1*numero2;
		JOptionPane.showMessageDialog(null, "A multiplicação "+numero1+" X "+numero2+" = "+resultado);
	}
	
}
}
