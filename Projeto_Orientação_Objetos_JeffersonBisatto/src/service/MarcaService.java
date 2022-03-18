package service;

import javax.swing.JOptionPane;

import controller.MarcaDAO;
import model.Marca;

public class MarcaService {

	
	/**
	 * Esse metodo pede o id para alterar ou remover, validando o que é digitado retornando um
	 *  index da marca ou -1 se ele cancelar a alteração
	 */	
	public int pedirIdMarca(String frase) {
		int respostas;
		String validaResposta;
		Marca marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		while (true) {
			try {
				validaResposta = JOptionPane
						.showInputDialog(marcaDAO.listaMarcaTxt() + "\nDigite o codigo para" + frase + ":");
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);

				marca = marcaDAO.buscarIndex(respostas);
				if (marca == null) {
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
