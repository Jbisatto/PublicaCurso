package view;

import javax.swing.JOptionPane;

public class AdministradoView {

	public void administradorTela(boolean senhaVerificada) {
		while (senhaVerificada) {
			try {
				int acao = Integer.parseInt(JOptionPane.showInputDialog("ADIMINISTRADOR LOGADO\n1-Gerenciar Usuários"
						+ "\n2-Gerenciar Marcas" + "\n3-Gerenciar Produtos" + "\n4-Realizar Venda" + "\n5-Fazer Logout"));
				switch (acao) {
				case 1: {
						FuncionarioView usuarioview = new FuncionarioView();
						usuarioview.tela("ADIMINISTRADOR");
					break;
				}
				case 2: {

					break;
				}
				case 3: {

					break;
				}
				case 4: {

					break;
				}
				case 5: {
					senhaVerificada = false;
					break;
				}
				default: {
					JOptionPane.showMessageDialog(null, "Opção invalida!!!");
					break;
				}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Caracter invalido!!!");
			}

		}
	}
	

}
