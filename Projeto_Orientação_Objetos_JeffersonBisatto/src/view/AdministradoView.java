package view;

import javax.swing.JOptionPane;

public class AdministradoView {

	public void administradorTela(boolean senhaVerificada) {
		while (senhaVerificada) {
			int acao = Integer.parseInt(JOptionPane.showInputDialog("ADIMINISTRADOR LOGADO\n1- Gerenciar Usuários"
					+ "\n2-Gerenciar Marcas" + "\n3-Gerenciar Produtos" + "\n4-Realizar Venda" + "\n5-Sair"));

			if (acao == 5) {
				senhaVerificada = false;
			}

		}
	}
}
