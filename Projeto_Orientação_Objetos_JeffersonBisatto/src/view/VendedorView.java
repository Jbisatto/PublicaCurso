package view;

import javax.swing.JOptionPane;

public class VendedorView {

	public void vendedorTela(boolean senhaVerificada) {

		while (senhaVerificada) {
			int acao = Integer
					.parseInt(JOptionPane.showInputDialog("VENDEDOR LOGADO\n1-Realizar Venda" + "\n2-Sair"));
			if (acao == 1) {
				VendasView vendaView = new VendasView();
				vendaView.tela("VENDEDOR");
			}
			
			if (acao == 2) {
				senhaVerificada = false;
			}

		}
	}
}
