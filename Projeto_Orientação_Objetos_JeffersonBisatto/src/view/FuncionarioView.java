package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;
import service.FuncionarioService;

public class FuncionarioView {

	/**
	 * Monta a Tela de cadastramento de Usuários
	 */
	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
		String verifica;
		while (senhaVerificada) {
			try {
				verifica=JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Usuário"
						+ "\n2-Alterar Usuário" + "\n3-Remover Usuario" + "\n4-Sair");
				if (verifica==null) {
					break;
				}
				int acao = Integer.parseInt(verifica);
				
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

	/**
	 * Executa o cadastramento de Usuários
	 */
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

	/**
	 * Executa a alteração de Usuários
	 */
	public void alterarUsuario() {
		int index;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		index = funcionarioService.pedirId(" alterar ",true);
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

	/**
	 * Executa a remoção de Usuários
	 */
	public void removerUsuario() {
		int index;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		index = funcionarioService.pedirId(" remover ", false);
		if (index != -1) {
			if(funcionarioDAO.remover(index)) {
				JOptionPane.showMessageDialog(null,
						"Funcionario Removido");
			}else {
				JOptionPane.showMessageDialog(null,
						"Esse Funcioanrio não pode ser removida pois existe Vendas vinculados a ele!!!");
			}
		}
	}

}
