package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;
import service.FuncionarioService;

public class FuncionarioView {

	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
//		Criar, Alterar e Excluir
		while (senhaVerificada) {
			try {
				int acao = Integer.parseInt(JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Usu�rio"
						+ "\n2-Alterar Usu�rio" + "\n3-Remover Usuario" + "\n4-Sair"));
				switch (acao) {
				case 1: {
					cadastrarUsuario();
					break;
				}
				case 2: {
					alterarUsuario();
					break;
				}
				case 3: {
					removerUsuario();
					break;
				}
				case 4: {
					senhaVerificada = false;
					break;
				}

				default: {
					JOptionPane.showMessageDialog(null, "Op��o invalida!!!");

				}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Caracter invalido!!!");
			}

		}

	}

	public void cadastrarUsuario() {

		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do usu�rio"));
		funcionario.setTelefone(JOptionPane.showInputDialog("Digite o telefone do usu�rio"));
		funcionario.setEmail(JOptionPane.showInputDialog("Digite o email do usu�rio"));
		funcionario.setLogin(JOptionPane.showInputDialog("Digite o login do usu�rio"));
		funcionario.setSenha(JOptionPane.showInputDialog("Digite a senha do usu�rio"));
		funcionario.setPerguntaSenha(JOptionPane.showInputDialog("Digite a data de nascimento do Pai"));
		funcionario.setSalario(funcionarioService.validaSalario(" "));
		funcionario.setTipo(funcionarioService.validaTipo(" "));

		funcionarioDAO.cadastrar(funcionario);
	}

	public void alterarUsuario() {
		int index;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		index = funcionarioService.pedirId(" alterar ");
		if (index != -1) {
			funcionario = funcionarioDAO.buscarIndex(index);
			funcionario.setNome(
					JOptionPane.showInputDialog("Digite o novo nome do usu�rio( " + funcionario.getNome() + "):"));
			funcionario.setTelefone(JOptionPane
					.showInputDialog("Digite o novo telefone do usu�rio( " + funcionario.getTelefone() + "):"));
			funcionario.setEmail(
					JOptionPane.showInputDialog("Digite o novo email do usu�rio( " + funcionario.getEmail() + "):"));
			funcionario.setLogin(
					JOptionPane.showInputDialog("Digite o novo login do usu�rio( " + funcionario.getLogin() + ")"));
			funcionario.setSenha(
					JOptionPane.showInputDialog("Digite a nova senha do usu�rio( " + funcionario.getSenha() + ")"));
			funcionario.setPerguntaSenha(JOptionPane
					.showInputDialog("Digite a data de nascimento do Pai( " + funcionario.getPerguntaSenha() + ")"));
			funcionario.setSalario(funcionarioService.validaSalario(" novo "));
			funcionario.setTipo(funcionarioService.validaTipo(" novo "));

			funcionarioDAO.alterar(funcionario, index);
		}
	}

	public void removerUsuario() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		funcionarioDAO.remover(funcionarioService.pedirIdSemAdm(" remover "));
	}



}
