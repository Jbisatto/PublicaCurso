package equals;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		//Obter nomes
		
		String nome1=JOptionPane.showInputDialog("1� nome: ");
		String nome2=JOptionPane.showInputDialog("2� nome: ");
		
		//Conpara��o
		if(nome1.equals(nome2)) {
			JOptionPane.showConfirmDialog(null, "S�o Iguais");
		}else {
			JOptionPane.showConfirmDialog(null, "S�o Diferentes");
		}
	}

}
