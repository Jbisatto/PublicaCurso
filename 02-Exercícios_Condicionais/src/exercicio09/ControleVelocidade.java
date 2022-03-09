package exercicio09;

import javax.swing.JOptionPane;

public class ControleVelocidade {

	public static void main(String[] args) {
		

		int velocidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade do veículo(KM)"));
		int velocidadeMaxima = Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade máxima permita(KM)"));

		if(velocidade<=velocidadeMaxima) {
			JOptionPane.showMessageDialog(null,"Bom Motorista!!!");
		}else if(velocidade>velocidadeMaxima&&velocidade<=(velocidadeMaxima+10)) {
			JOptionPane.showMessageDialog(null,"Multa de R$50,00");
		}else if(velocidade>velocidadeMaxima&&velocidade<=(velocidadeMaxima+20)) {
			JOptionPane.showMessageDialog(null,"Multa de R$100,00");
		}else {
			JOptionPane.showMessageDialog(null,"Multa de R$200,00");
		}
	}

}
