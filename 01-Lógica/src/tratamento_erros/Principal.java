package tratamento_erros;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		boolean valida=false;
		do {
		try {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero"));
		System.out.println(numero);
		valida=true;
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null,"Falha "+ erro);
		}
		}while(valida==false);
		

	}

}
