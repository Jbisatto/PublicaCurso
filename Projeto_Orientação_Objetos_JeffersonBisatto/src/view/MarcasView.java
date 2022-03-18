package view;

import javax.swing.JOptionPane;

import controller.MarcaDAO;
import model.Marca;
import service.MarcaService;

public class MarcasView {

	/**
	 * Monta a Tela de cadastramento de Marcas
	 */
	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
		String verifica;
		while (senhaVerificada) {
			try {
				verifica = JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Marca" + "\n2-Alterar Marca"
						+ "\n3-Remover Marca" + "\n4-Sair");
				if (verifica == null) {
					break;
				}
				int acao = Integer.parseInt(verifica);
				switch (acao) {
				case 1: {
					cadastrarMarca();
					break;
				}
				case 2: {
					alterarMarca();
					break;
				}
				case 3: {
					removerMarca();
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
	 * Executa o cadastramento de Marcas
	 */
	private void cadastrarMarca() {

		Marca marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		marca.setNome(JOptionPane.showInputDialog("Digite o nome da Marca"));
		marcaDAO.cadastrar(marca);

	}

	/**
	 * Executa a alteração de Marcas
	 */
	private void alterarMarca() {
		int index;
		Marca marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		MarcaService marcaService = new MarcaService();
		index = marcaService.pedirIdMarca(" alterar ");
		if (index != -1) {
			marca = marcaDAO.buscarIndex(index);
			marca.setNome(JOptionPane.showInputDialog("Digite o novo nome do usuário( " + marca.getNome() + "):"));

			marcaDAO.alterar(marca, index);
		}
	}

	/**
	 * Executa a remoção de Marcas
	 */
	private void removerMarca() {
		MarcaDAO marcaDAO = new MarcaDAO();
		MarcaService marcaService = new MarcaService();

		if (marcaDAO.remover(marcaService.pedirIdMarca(" remover "))) {
			JOptionPane.showMessageDialog(null, "Marca removida!!!");
		} else {
			JOptionPane.showMessageDialog(null,
					"Essa marca não pode ser removida pois existe Produtos vinculados a ela!!!");
		}

	}

}
