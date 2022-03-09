package exercicio19;

import javax.swing.JOptionPane;

public class Imc {

	public static void main(String[] args) {

		double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe a peso:"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Informe a altura:"));
		double imc= peso / (altura * altura);
		
		if (imc<17.5) {
			JOptionPane.showMessageDialog(null, "Abaixo do Peso!!!");
		}else if (imc>=17.5&&imc<=24.99) {
			JOptionPane.showMessageDialog(null, "Peso Normal!!!");
		}else if (imc>=25&&imc<=29.99) {
			JOptionPane.showMessageDialog(null, "Acima do Peso!!!");
		}else if (imc>=30&&imc<=34.99) {
			JOptionPane.showMessageDialog(null, "Obesidade 1!!!");
		}else if (imc>=35&&imc<=39.99) {
			JOptionPane.showMessageDialog(null, "Obesidade 2!!!");
		}else{
			JOptionPane.showMessageDialog(null, "Obesidade 3!!!");
		}
	}

//Abaixo de 17.5
//Abaixo do peso
//Entre 17.5 e 24.99
//Peso normal
//Entre 25 e 29.99
//Acima do peso
//Entre 30 e 34.99
//Obesidade 1
//Entre 35 e 39.99
//Obesidade 2
//A partir de 40
//Obesidade 3



}
