package confirmDialog;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
	//ConfirmDialog
	int acao = JOptionPane.showConfirmDialog(null, "Escolha uma op��o");
	
	//Retorna a A��o
	JOptionPane.showMessageDialog(null, acao);
	
	

	}

}
