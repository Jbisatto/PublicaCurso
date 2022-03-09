package exercicio11;

import java.util.Random;

import javax.swing.JOptionPane;

public class AdvinharNumero {

	public static void main(String[] args) {
		
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(100) + 1;
		int numero,qtdTentativas=0;
		System.out.println("Número gerado: " + valor);
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero ou 0 para encerrrar!!!"));
			qtdTentativas++;
			if(numero>valor) {
				JOptionPane.showMessageDialog(null, "O numero é menor!!!");
			}if(numero<valor) {
				JOptionPane.showMessageDialog(null, "O numero é maior!!!");
			}
		}while(numero!=valor);
		
		JOptionPane.showMessageDialog(null, "Vc acertou o numero é "+valor+"\nQuantidade de tentativas = "+qtdTentativas);
		
		
		
		
	}

}
