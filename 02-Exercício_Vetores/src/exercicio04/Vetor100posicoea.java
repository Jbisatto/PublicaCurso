package exercicio04;

import javax.swing.JOptionPane;

public class Vetor100posicoea {

	public static void main(String[] args) {
		String[] nomes = new String[100];
		int sair = 1, contador = 0;
		while (sair != 0 && contador < nomes.length) {
			nomes[contador] = JOptionPane.showInputDialog("Informe o nome: ");
			sair = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 para sair ou 1 para continuar!"));
			contador++;
		}
		for (int i = 0; i < contador; i++) {
			System.out.println(nomes[i]);
		}

	}

}
