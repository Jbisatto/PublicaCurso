package exercicio05;

import javax.swing.JOptionPane;

public class PessoaMaisVelha {

	public static void main(String[] args) {
		String nome;
		String nomeMaisVelha="";
		int idade, parar;
		int idadeMaisVelha = 0;
		do {
			nome = JOptionPane.showInputDialog("Digite o nome");
			idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
			if (idade > idadeMaisVelha) {
				idadeMaisVelha = idade;
				nomeMaisVelha = nome;
			}
			parar = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para parar!!!"));

		} while (parar == 0);
		JOptionPane.showMessageDialog(null,"A Pessoa mais velha é "+nomeMaisVelha+" e tem "+idadeMaisVelha+" anos");
	}

}
