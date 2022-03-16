package view;

import javax.swing.JOptionPane;

public class GerenteView {

	public void gerenteTela(boolean senhaVerificada) {
		
		while (senhaVerificada) {
			int acao = Integer.parseInt(JOptionPane.showInputDialog("GERENTE LOGADO"
					+ "\n1-Gerenciar Marcas" + "\n2-Gerenciar Produtos" + "\n3-Realizar Venda" + "\n4-Sair"));

			if (acao == 4) {
				senhaVerificada = false;
			}

		}
	}
}
