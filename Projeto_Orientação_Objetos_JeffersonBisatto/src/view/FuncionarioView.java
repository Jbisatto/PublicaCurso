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
				int acao = Integer.parseInt(JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Usuário"
						+ "\n2-Alterar Usuário" + "\n3-Remover Usuario" + "\n4-Sair"));
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
					JOptionPane.showMessageDialog(null, "Opção invalida!!!");

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
		funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do usuário"));
		funcionario.setTelefone(JOptionPane.showInputDialog("Digite o telefone do usuário"));
		funcionario.setEmail(JOptionPane.showInputDialog("Digite o email do usuário"));
		funcionario.setLogin(JOptionPane.showInputDialog("Digite o login do usuário"));
		funcionario.setSenha(JOptionPane.showInputDialog("Digite a senha do usuário"));
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
					JOptionPane.showInputDialog("Digite o novo nome do usuário( " + funcionario.getNome() + "):"));
			funcionario.setTelefone(JOptionPane
					.showInputDialog("Digite o novo telefone do usuário( " + funcionario.getTelefone() + "):"));
			funcionario.setEmail(
					JOptionPane.showInputDialog("Digite o novo email do usuário( " + funcionario.getEmail() + "):"));
			funcionario.setLogin(
					JOptionPane.showInputDialog("Digite o novo login do usuário( " + funcionario.getLogin() + ")"));
			funcionario.setSenha(
					JOptionPane.showInputDialog("Digite a nova senha do usuário( " + funcionario.getSenha() + ")"));
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
