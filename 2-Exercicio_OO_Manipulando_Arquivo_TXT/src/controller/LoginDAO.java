package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Login;

public class LoginDAO {

	public static ArrayList<Login> listaLogin = new ArrayList<>();

	public void salvarObjeto(Login login) {
		listaLogin.add(login);

	}

	public Login buscar() {

		return listaLogin.get(0);
	}

	public char autenticar(String inserirLogin, int inserirSenha) {
		for (int i = 0; i < listaLogin.size(); i++) {
			if (listaLogin.get(i).getNome().equals(inserirLogin) && listaLogin.get(i).getSenha() == inserirSenha) {
				return listaLogin.get(i).getNivel();
			}
		}
		return 0;
	}

	public String buscarTodos() {
		String user = "";
		for (int i = 0; i < listaLogin.size(); i++) {
			user +="Cod: "+i+", User: "+ listaLogin.get(i).getNome()+", Senha: "+listaLogin.get(i).getSenha()+", Tipo: "+listaLogin.get(i).getNivel()+"\n";
		}
		return user;
	}
	public String listaSalvar() {
		String user = "";
		for (int i = 0; i < listaLogin.size(); i++) {
			user += listaLogin.get(i) + "\n";
		}
		return user;
	}

	public void saltarTxtLogin() {
		try {
			FileWriter escrever = new FileWriter("arquivoLogin.txt");
			escrever.write(listaSalvar());
			escrever.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Login buscarId(int acaoAlterar) {
		
		return listaLogin.get(acaoAlterar);
	}

	public void alterarLogin(Login login, int acaoAlterar) {
		listaLogin.set(acaoAlterar, login);
		
	}

	public void removerLogin(int acaoAlterar) {
		listaLogin.remove(acaoAlterar);
		
	}



}
