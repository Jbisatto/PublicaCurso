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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object> listarTodos() {

		return null;
	}

	@Override
	public void alterar(Object obj) {
		// TODO Auto-generated method stub

	}

	public String listaFuncionarioTxt() {
		String lista = "Lista:\n";
		for (int i = 0; i < listaFuncionario.size(); i++) {
			lista += "Nome: " + listaFuncionario.get(i).getNome() + "\nTipo: " + listaFuncionario.get(i).getTipo()
					+ "\nTelefone: " + listaFuncionario.get(i).getTelefone() + "\nEmail: "
					+ listaFuncionario.get(i).getEmail() + "\nSalario: " + listaFuncionario.get(i).getSalario()
					+ "\nLogin: " + listaFuncionario.get(i).getLogin() + "\nSenha: "
					+ listaFuncionario.get(i).getSenha() + "\n";
		}
		return lista;
	}

	public char verificaSenha(String login, String senha) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getLogin().equals(login) && listaFuncionario.get(i).getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com  sucesso");
				return listaFuncionario.get(i).getTipo();
			}

		}
		return '0';
	}

	public boolean buscarLogin(String login) {
		for (int i = 0; i < listaFuncionario.size(); i++) {
			if (listaFuncionario.get(i).getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

}
