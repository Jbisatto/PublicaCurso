package service;

import javax.swing.JOptionPane;

import controller.ProdutoDAO;
import model.Administrador;
import model.Gerente;
import model.Produto;
import model.Vendedor;

public class ProdutoService {

	/**
	 * Pede o valor do Produto e valida os possiveis erros de digitação, as
	 * variaveis são para especificar se esta cadastrando ou alterando
	 */
	public double validarValor(String frase, String frase2) {
		double valor = 0;
		while (true) {
			try {
				valor = Double
						.parseDouble(JOptionPane.showInputDialog("Digite o" + frase + "valor do produto" + frase2));
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um valor válido!!!");
			}
		}
		return valor;
	}

	/**
	 * Esse metodo pede o id para alterar ou remover, validando o que é digitado retornando um
	 * index da produto ou -1 se ele cancelar a alteração
	 */
	public int pedirIdProduto(String frase) {
		int respostas;
		String validaResposta;
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		while (true) {
			try {
				validaResposta = JOptionPane.showInputDialog(
						produtoDAO.listaProdutoTxt() + "\nDigite o codigo do Produto para " + frase + ":");
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);
				produto = produtoDAO.buscarIndex(respostas);
				if (produto == null) {
					throw new IllegalArgumentException("Valor invalido");
				}
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um caracter invalido!!!");
			}
		}
		return respostas;
	}

	
	/**
	 * Pede o qtd do Produto e valida os possiveis erros de digitação
	 */
	public int validarQuantidade() {
		int valor = 0;
		while (true) {
			try {
				valor = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de Produto para comprar:"));
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um valor válido!!!");
			}
		}
		return valor;
	}

	/**
	 * Calcula a comissão referente ao tipo de Funcionário
	 */
	public double calculaComissao(String cargo, double valor) {
		if (cargo.equals("Administrador")) {
			Administrador administrador = new Administrador();
			return administrador.comissao(valor);

		} else if (cargo.equals("Gerente")) {
			Gerente gerente = new Gerente();
			return gerente.comissao(valor);
		} else {
			Vendedor vendendor = new Vendedor();
			return vendendor.comissao(valor);
		}
	}

}
