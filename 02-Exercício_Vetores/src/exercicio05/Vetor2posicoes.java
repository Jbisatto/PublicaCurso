package exercicio05;

import javax.swing.JOptionPane;

public class Vetor2posicoes {

	public static void main(String[] args) {
		
		String [][] pessoa = new String[10][2];
		
		for (int i = 0; i < 10; i++) {
			pessoa[i][0]=JOptionPane.showInputDialog("Informe o nome da Pessoa: ");
			pessoa[i][1]=JOptionPane.showInputDialog("Informe a idade da Pessoa: ");
			
		}
		for (int i = 0; i < pessoa.length; i++) {
			System.out.println("---------------------\n| Nome: "+pessoa[i][0]+", Idade: "+pessoa[i][1]+" |\n---------------------");
			
		}

	}

}
