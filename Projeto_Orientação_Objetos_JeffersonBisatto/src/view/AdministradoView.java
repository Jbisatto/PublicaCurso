package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;

public class AdministradoView {

	/**
	 * Monta a Tela do Administrador
	 */
	public void administradorTela(boolean senhaVerificada) {
		while (senhaVerificada) {
			try {
				int acao = Integer.parseInt(JOptionPane.showInputDialog("ADIMINISTRADOR LOGADO\n1-Gerenciar Usuários"
						+ "\n2-Gerenciar Marcas" + "\n3-Gerenciar Produtos" + "\n4-Realizar Venda"
						+ "\n5-Extrato de comissões" + "\n6-Fazer Logout"));
				switch (acao) {
				case 1: {
					FuncionarioView usuarioview = new FuncionarioView();
					usuarioview.tela("ADIMINISTRADOR");
					break;
				}
				case 2: {
					MarcasView marcaView = new MarcasView();
					marcaView.tela("ADIMINISTRADOR");
					break;
				}
				case 3: {
					ProdutoView produtoView = new ProdutoView();
					produtoView.tela("ADIMINISTRADOR");
					break;
				}
				case 4: {
					VendasView vendaView = new VendasView();
					vendaView.tela("ADIMINISTRADOR");
					break;
				}
				case 5: {
					gerarExtrato();
					break;
				}
				case 6: {
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

	/**
	 * Monta a Tela de Extrato
	 */
	public void gerarExtrato() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		JOptionPane.showMessageDialog(null,
				"------------------------------------------------------EXTRATO COMISSÕES"
						+ "------------------------------------------------------" + "\n"
						+ funcionarioDAO.listaComissoesVendas());

	}

}
