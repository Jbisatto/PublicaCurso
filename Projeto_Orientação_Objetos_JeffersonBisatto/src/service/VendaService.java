package service;

import javax.swing.JOptionPane;

import controller.VendaDAO;
import model.Venda;

public class VendaService {

	/**
	 * Pede o codigo da Venda do produto, listando todas as vendas e validando se
	 * foi informando corretamente
	 */
	public int pedirIdVenda(String frase) {
		int respostas;
		String validaResposta;
		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();
		while (true) {
			try {
				validaResposta = JOptionPane
						.showInputDialog(vendaDAO.listaVendaTxt() + "\nDigite o codigo para" + frase + ":");
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);

				venda = vendaDAO.buscarIndex(respostas);
				if (venda == null) {
					throw new IllegalArgumentException("Valor invalido");
				}
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um caracter invalido!!!");
			}
		}
		return respostas;
	}

}
