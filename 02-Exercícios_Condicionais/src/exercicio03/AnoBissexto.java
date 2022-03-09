package exercicio03;

import javax.swing.JOptionPane;

public class AnoBissexto {

	public static void main(String[] args) {
		 int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano"));
		 if(ano%4==0) {
			 JOptionPane.showMessageDialog(null,"O ano é Bissexto!");
		 }else {
			 JOptionPane.showMessageDialog(null,"O ano não é Bissexto!");
		 }

	}

}
