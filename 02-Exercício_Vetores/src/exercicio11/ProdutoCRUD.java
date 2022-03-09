package exercicio11;

import javax.swing.JOptionPane;

public class ProdutoCRUD {

	public static void main(String[] args) {

		boolean parar = true;
		int numero=0;
		String[][] produtos = new String[50][3];
		String menu = "1-Cadastrar\n2-Listar\n3-Alterar\n4-Remover\n5-Sair";
		
		do {
			numero=Integer.parseInt(JOptionPane.showInputDialog(menu));
			if(numero==5) {	
				parar=false;
			}else {
			
				
				
				
				
			}
		} while (parar);

	}

}
