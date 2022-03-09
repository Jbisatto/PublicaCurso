package confirmDialog;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
	//ConfirmDialog
	int acao = JOptionPane.showConfirmDialog(null, "Escolha uma opção");
	
	//Retorna a Ação
	JOptionPane.showMessageDialog(null, acao);
	
	

	}

}
