package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.LoginDAO;
import controller.ProdutoDAO;
import modelo.Login;
import modelo.Produto;

public class Principal {

	public static void main(String[] args) {
////		Login loginGerente = new Login();
//		Login loginAministrador = new Login();
//		loginAministrador.setNivel('A');
//		loginAministrador.setNome("adm");
//		loginAministrador.setSenha(123);
//		
////		loginGerente.setNivel('G');
////		loginGerente.setNome("gerente");
////		loginGerente.setSenha(123);
//
////Criar Arquivo e Escrever	
//		try {
//			FileWriter escrever = new FileWriter("arquivoLogin.txt");
//			escrever.write(loginAministrador.toString());
////			escrever.write("\n" + loginGerente.toString());
//			escrever.close();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//Ler Login
		LoginDAO loginDAo = new LoginDAO();
		try {
			File arquivoLogin = new File("arquivoLogin.txt");
			Scanner scanner;
			scanner = new Scanner(arquivoLogin);
			String[] objetos;

			while (scanner.hasNextLine()) {
				Login login = new Login();
				objetos = scanner.nextLine().split(",");
				login.setNome(objetos[0]);
				login.setSenha(Integer.parseInt(objetos[1]));
				login.setNivel(objetos[2].charAt(0));
				loginDAo.salvarObjeto(login);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//LER PRODUTOS

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			File arquivoProduto = new File("arquivoProduto.txt");
			Scanner scanner;
			scanner = new Scanner(arquivoProduto);
			String[] objetos;

			while (scanner.hasNextLine()) {
				Produto produto = new Produto();
				objetos = scanner.nextLine().split(",");
				produto.setNomeProduto(objetos[0]);
				produto.setValor(Double.parseDouble(objetos[1]));

				produtoDAO.salvarProduto(produto);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String inserirLogin = JOptionPane.showInputDialog("Digite o login:");
		int inserirSenha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha:"));

		char resposta = loginDAo.autenticar(inserirLogin, inserirSenha);

		if (resposta == 'A') {
			boolean sairADM = true;
			while (sairADM) {
				int acao = Integer
						.parseInt(JOptionPane.showInputDialog("Aministrador logado:\n1-Usuários\n2-Produtos\n3-Sair"));
				switch (acao) {
				case 1: {
					boolean sair = true;
					while (sair) {
						int acaoGerente = Integer.parseInt(JOptionPane.showInputDialog(
								"Cadastrar ou Editar Usuários:\n1-Cadastrar\n2-Listar\n3-Alterar\n4-Remover\n5-Sair"));
						if (acaoGerente == 1) {
							Login login = new Login();
							login.setNome(JOptionPane.showInputDialog("Digite um novo Login:"));
							login.setSenha(Integer.parseInt(JOptionPane.showInputDialog("Digite a senha")));
							login.setNivel(JOptionPane
									.showInputDialog("Digite o tipo de Usuário\nA-Administrador\nG-Gerente").charAt(0));
							loginDAo.salvarObjeto(login);

							loginDAo.saltarTxtLogin();

						} else if (acaoGerente == 2) {
							JOptionPane.showMessageDialog(null, "Lista de Usuários\n" + loginDAo.buscarTodos());

						} else if (acaoGerente == 3) {
							int acaoAlterar = Integer.parseInt(JOptionPane.showInputDialog("Lista de Usuários\n"
									+ loginDAo.buscarTodos() + "\n----------------------------------\n"
									+ "Digite o código do usuáro parar alterar:"));

							Login login = new Login();
							login = loginDAo.buscarId(acaoAlterar);
							login.setNome(
									JOptionPane.showInputDialog("Digite um novo Login( " + login.getNome() + " ):"));
							login.setSenha(Integer.parseInt(
									JOptionPane.showInputDialog("Digite uma nova senha( " + login.getSenha() + " ):")));
							login.setNivel(JOptionPane.showInputDialog(
									"Digite o tipo de Usuário( " + login.getNivel() + " ):\nA-Administrador\nG-Gerente")
									.charAt(0));
							loginDAo.alterarLogin(login, acaoAlterar);
							loginDAo.saltarTxtLogin();
						} else if (acaoGerente == 4) {
							int acaoAlterar = Integer.parseInt(JOptionPane.showInputDialog("Lista de Usuários\n"
									+ loginDAo.buscarTodos() + "\n----------------------------------\n"
									+ "Digite o código do usuáro parar remover:"));
							loginDAo.removerLogin(acaoAlterar);
							loginDAo.saltarTxtLogin();
						} else {
							sair = false;
						}

					}
					break;
				}
				case 2: {
					boolean sairProdutos = true;
					while (sairProdutos) {
						Produto produto = new Produto();
						ProdutoDAO produtoDAO = new ProdutoDAO();
						int acaoProduto = Integer.parseInt(JOptionPane.showInputDialog(
								"Cadastrar ou Editar Produtos:\n1-Cadastrar\n2-Listar\n3-Alterar\n4-Remover\n5-Sair"));

						if (acaoProduto == 1) {
							produto.setNomeProduto(JOptionPane.showInputDialog("Insira nome produto:"));
							produto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Insirar o valor:")));
							produtoDAO.salvarProduto(produto);
							produtoDAO.saltarTxtProduto();
						} else if (acaoProduto == 2) {
							JOptionPane.showMessageDialog(null, "Lista de Produtos\n" + produtoDAO.buscarTodos());
						} else if (acaoProduto == 3) {
							int acaoAlterar = Integer.parseInt(JOptionPane.showInputDialog("Lista de Produtos\n"
									+ produtoDAO.buscarTodos() + "\n----------------------------------\n"
									+ "Digite o código do produto parar alterar:"));

							Produto produtoAlterar = new Produto();
							produtoAlterar = produtoDAO.buscarId(acaoAlterar);
							produtoAlterar.setNomeProduto(JOptionPane.showInputDialog(
									"Digite um novo nome Produto( " + produtoAlterar.getNomeProduto() + " ):"));
							produtoAlterar.setValor(Double.parseDouble(JOptionPane
									.showInputDialog("Digite uma nova senha( " + produtoAlterar.getValor() + " ):")));

							produtoDAO.alterarProduto(produtoAlterar, acaoAlterar);
							produtoDAO.saltarTxtProduto();
						} else if (acaoProduto == 4) {
							int acaoRemover = Integer.parseInt(JOptionPane.showInputDialog("Lista de Usuários\n"
									+ loginDAo.buscarTodos() + "\n----------------------------------\n"
									+ "Digite o código do usuáro parar remover:"));
//							loginDAo.removerLogin(acaoAlterar);
							loginDAo.saltarTxtLogin();
						} else {
							sairProdutos = false;
						}
					}
					break;
				}
				case 3: {
					sairADM = false;
					break;
				}
				default: {
					throw new IllegalArgumentException("Unexpected value: " + acao);
				}
				}
			}
		} else if (resposta == 'G') {
			int acao = Integer.parseInt(JOptionPane.showInputDialog("Gerente logado:\n1-Cadastrar Produtos\n2-Sair"));

			JOptionPane.showMessageDialog(null, resposta);
		} else {
			JOptionPane.showMessageDialog(null, "Login/Senha incorretas!!!");
		}
		JOptionPane.showMessageDialog(null, resposta);

	}

}
