package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;
import service.FuncionarioService;

public class FuncionarioView {

	/**
	 * Monta a Tela de cadastramento de Usu�rios
	 */
	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
		String verifica;
		while (senhaVerificada) {
			try {
				verifica=JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Usu�rio"
						+ "\n2-Alterar Usu�rio" + "\n3-Remover Usuario" + "\n4-Sair");
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
					JOptionPane.showMessageDialog(null, "Op��o invalida!!!");

				}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Caracter invalido!!!");
			}

		}

	}

	/**
	 * Executa o cadastramento de Usu�rios
	 */
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

	/**
	 * Executa a altera��o de Usu�rios
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

	/**
	 * Executa a remo��o de Usu�rios
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
						"Esse Funcioanrio n�o pode ser removida pois existe Vendas vinculados a ele!!!");
			}
		}
	}

}
