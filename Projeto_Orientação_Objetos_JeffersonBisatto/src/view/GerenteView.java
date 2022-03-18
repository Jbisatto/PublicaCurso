package view;

import javax.swing.JOptionPane;

public class GerenteView {

	/**
	 * Monta a Tela do Gerente
	 */
	public void gerenteTela(boolean senhaVerificada) {
		
		while (senhaVerificada) {
			try {
				int acao = Integer.parseInt(JOptionPane.showInputDialog("GERENTE LOGADO\n1-Gerenciar Marcas" +
			"\n2-Gerenciar Produtos" + "\n3-Realizar Venda" + "\n4-Fazer Logout"));
				switch (acao) {
				case 1: {
					MarcasView marcaView = new MarcasView();
					marcaView.tela("GERENTE");
					break;
				}
				case 2: {
					ProdutoView produtoView = new ProdutoView();
					produtoView.tela("GERENTE");
					break;
				}
				case 3: {
					VendasView vendaView = new VendasView();
					vendaView.tela("GERENTE");
					break;
				}
				case 4: {
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
