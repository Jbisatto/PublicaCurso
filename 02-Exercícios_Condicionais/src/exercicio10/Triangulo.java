package exercicio10;

import javax.swing.JOptionPane;

public class Triangulo {

	public static void main(String[] args) {
		
		int ladoDireito = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões de um triângulo (lado direito)"));
		int ladoEsquerdo = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões de um triângulo (lado esquerdo)"));
		int ladoInferior = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões de um triângulo (lado inferior)"));

		if(ladoDireito==ladoEsquerdo && ladoDireito==ladoInferior&&ladoEsquerdo==ladoInferior) {
			JOptionPane.showMessageDialog(null,"Esse Triângulo é do tipo Equilátero.");
		}else if(ladoDireito!=ladoEsquerdo && ladoDireito!=ladoInferior&&ladoEsquerdo!=ladoInferior){
			JOptionPane.showMessageDialog(null,"Esse Triângulo é do tipo Escaleno.");
		}else {
			JOptionPane.showMessageDialog(null,"Esse Triângulo é do tipo Isósceles.");
		}
	}

}
