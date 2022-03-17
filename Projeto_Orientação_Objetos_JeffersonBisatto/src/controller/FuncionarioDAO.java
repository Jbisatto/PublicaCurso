package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Funcionario;

public class FuncionarioDAO implements ICrud {
	static ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

	@Override
	public void cadastrar(Object obj) {
		listaFuncionario.add((Funcionario) obj);

	}

	@Override
	public void remover(int index) {
		listaFuncionario.remove(index);

	}

	@Override
	public List<Object> listarTodos() {

		return null;
	}

	@Override
	public void alterar(Object obj, int index) {
		listaFuncionario.set(index, (Funcionario) obj);

	}

	
//retorna toda a lista de Usuarios cadastrados
	public String listaFuncionarioTxt() {
		String lista = "Lista:\n";
		for (int i = 0; i < listaFuncionario.size(); i++) {
			lista += "Cod: " + i + listaFuncionario.get(i) + "\n";
		}
		return lista;
	}
//verifica se o login e senha estão certo e retora o a posição do Usuario no array, caso não encontre retorna -1
	public int verificaSenha(String login, String senha) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getLogin().equals(login) && listaFuncionario.get(i).getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com  sucesso");
				return i;
			}
		}
		return -1;
	}

	
//	verifica se o login existe
	public boolean buscarLogin(String login) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}
	
	
//retorna o a possição dele no array buscado pelo telefone e login
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
//retorna o a possição dele no array buscado pelo email e login
	public int buscarEmail(String email, String login) {
		int index = -1;
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getEmail().equals(email) && listaFuncionario.get(i).getLogin().equals(login)) {
				index = i;
			}
		}

		return index;
	}
	
	
//Retorna um Funcionario pelo Index, verificando se o index existe
	public Funcionario buscarIndex(int index) {
			if(index>=0
					&&index<=(listaFuncionario.size()-1)) {
				return listaFuncionario.get(index);
		}

		return null;
	}
	
	
//retorna o tipo de funcionario pelo Tipo dele
	public char buscarTipo(int indexUsuario) {
		return listaFuncionario.get(indexUsuario).getTipo();
	}

	
//	Retorna o tipo do usuario, ou retorna E se caso não exista esse tipo
	public char buscarTipoCadastrar(int tipo) {
		if (tipo == 1) {
			return 'A';
		} else if (tipo == 2) {
			return 'G';
		} else if (tipo == 3) {
			return 'V';
		} else {
			return 'E';
		}
	}

}
