package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Funcionario;
import service.FuncionarioService;

public class FuncionarioDAO implements ICrud<Funcionario> {

	static ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

	/**
	 * Cadastra um Funcionario na lista
	 */
	@Override
	public void cadastrar(Funcionario obj) {
		listaFuncionario.add(obj);

	}

	/**
	 * Verifica se tem alguma venda relacionado com o Funcionario que esta tentando
	 * remover, e remove ele da lista retornando true;
	 */
	@Override
	public boolean remover(int index) {
		VendaDAO vendaDAO = new VendaDAO();
		if (vendaDAO.verificaFuncioanrio(index)) {
			return false;
		} else {
			listaFuncionario.remove(index);
			return false;
		}
	}

	/**
	 * Altera um Funcionario recebendo ele e o indice nele do array
	 */
	@Override
	public void alterar(Funcionario obj, int index) {
		listaFuncionario.set(index, obj);

	}

	/**
	 * verifica se o login e senha estão certo e retora o a posição do Usuario no
	 * array, caso não encontre retorna -1 para tratamento de erros
	 */
	public int verificaSenha(String login, String senha) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getLogin().equals(login) && listaFuncionario.get(i).getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com  sucesso");
				return i;
			}
		}
		return -1;
	}

	/**
	 * verifica se o login existe
	 */
	public boolean buscarLogin(String login) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * retorna o a possição dele no array buscado pelo telefone e login
	 */
	public int buscarTelefone(String telefone, String login) {
		int index = -1;
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getTelefone().equals(telefone)
					&& listaFuncionario.get(i).getLogin().equals(login)) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * retorna o a possição dele no array buscado pelo email e login
	 */
	public int buscarEmail(String email, String login) {
		int index = -1;
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getEmail().equals(email) && listaFuncionario.get(i).getLogin().equals(login)) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * Retorna um Funcionario pelo Index, verificando se o index existe
	 */
	public Funcionario buscarIndex(int index) {
		if (index >= 0 && index <= (listaFuncionario.size() - 1)) {
			return listaFuncionario.get(index);
		}
		return null;
	}

	/**
	 * retorna o tipo de funcionario pelo Tipo dele
	 */
	public char buscarTipo(int indexUsuario) {
		return listaFuncionario.get(indexUsuario).getTipo();
	}

	/**
	 * Monta uma String de lista com apenas o codigo e nome do Fucnionario
	 */
	public String listaFuncionarioTxtPersonalizado(boolean mostraAdm) {
		String lista = "Lista:\n";
		for (int i = (mostraAdm) ? 0 : 1; i < listaFuncionario.size(); i++) {
			System.out.println(i);
			lista += "Cod: " + i + ", Nome: " + listaFuncionario.get(i).getNome() + "\n";
		}
		return lista;
	}

	/**
	 * Monta uma String de lista de comissões de todos os vendedores, mesmo se o
	 * vendedor não fez venda
	 */
	public String listaComissoesVendas() {
		String lista = "", cargo = "";
		VendaDAO vendaDAO = new VendaDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		for (int i = 0; i < listaFuncionario.size(); i++) {
			cargo = funcionarioService.cargoFuncionario(listaFuncionario.get(i).getTipo());

			lista += "Tipo: " + cargo + "  Nome: " + listaFuncionario.get(i).getNome()
					+ vendaDAO.extratoVendas(i, cargo) + "\n";
		}
		return lista;
	}

}
