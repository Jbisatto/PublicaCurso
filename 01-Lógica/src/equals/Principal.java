package equals;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		//Obter nomes
		
		String nome1=JOptionPane.showInputDialog("1° nome: ");
		String nome2=JOptionPane.showInputDialog("2° nome: ");
		
		//Conparação
		if(nome1.equals(nome2)) {
			JOptionPane.showConfirmDialog(null, "São Iguais");
		}else {
			JOptionPane.showConfirmDialog(null, "São Diferentes");
		}
	}

}
