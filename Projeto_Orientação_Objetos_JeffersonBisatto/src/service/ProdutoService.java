package service;

import javax.swing.JOptionPane;

import controller.ProdutoDAO;
import model.Produto;

public class ProdutoService {
	
	
//	Pede o valor do Produto e valida os possiveis erros de digitação
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
	
	// Esse metodo pede o id para alterar validando o que é digitado retornando um
	// index da produto ou -1 se ele cancelar a alteração
	public int pedirIdProduto(String frase) {
		int respostas;
		String validaResposta;
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		while (true) {
			try {
				validaResposta = JOptionPane.showInputDialog(
						produtoDAO.listaProdutoTxt() + "\nDigite o codigo do Produto para " + frase + ":");
//				se apertar no botão cancelar retornará -1
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);// se digitar algo diferente de um numero sera gerado uma
																// execeção
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
	
//	Pede o qtd do Produto e valida os possiveis erros de digitação
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


}
