package exercicio10;

import javax.swing.JOptionPane;

public class Triangulo {

	public static void main(String[] args) {
		
		int ladoDireito = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimens�es de um tri�ngulo (lado direito)"));
		int ladoEsquerdo = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimens�es de um tri�ngulo (lado esquerdo)"));
		int ladoInferior = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimens�es de um tri�ngulo (lado inferior)"));

		if(ladoDireito==ladoEsquerdo && ladoDireito==ladoInferior&&ladoEsquerdo==ladoInferior) {
			JOptionPane.showMessageDialog(null,"Esse Tri�ngulo � do tipo Equil�tero.");
		}else if(ladoDireito!=ladoEsquerdo && ladoDireito!=ladoInferior&&ladoEsquerdo!=ladoInferior){
			JOptionPane.showMessageDialog(null,"Esse Tri�ngulo � do tipo Escaleno.");
		}else {
			JOptionPane.showMessageDialog(null,"Esse Tri�ngulo � do tipo Is�sceles.");
		}
	}

}
