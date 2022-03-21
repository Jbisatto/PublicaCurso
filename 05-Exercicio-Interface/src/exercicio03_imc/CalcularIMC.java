package exercicio03_imc;

import javax.swing.JOptionPane;

public class CalcularIMC {

	public static String calculaImcTxt(String txtAltura, String txtPeso) {
		double altura, peso;
			try {
				altura = Double.parseDouble(txtAltura);
				peso = Double.parseDouble(txtPeso);
				return calculaImc(peso/(altura*altura));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valores inválido!!!");
			}
			return "";
		
	}
	public static String calculaImc(double valorImc) {
			if(valorImc<18.5) {
				return "Abaixo do Peso!!!";
			}else if(valorImc>=18.5&&valorImc<=24.9) {
				return "Peso Normal!!!";
			}else if(valorImc>=25&&valorImc<=29.9) {
				return "Sobrepeso!!!";
			}else if(valorImc>=30&&valorImc<=34.9) {
				return "Obesidade Grau 1!!!";
			}else if(valorImc>=35&&valorImc<=39.9) {
				return "Obesidade Grau 2!!!";
			}else {
				return "Obesidade Grau 3 ou Morbida!!!";
			}

	}

}
