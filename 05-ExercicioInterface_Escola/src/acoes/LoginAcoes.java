package acoes;

import java.util.List;

import bd.Bd;
import modelo.Login;

public class LoginAcoes implements ICrud<Login> {

	@Override
	public void cadastrar(Login obj) {
		Bd.listaLogin.add(obj);
		
	}

	@Override
	public List<Login> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Login obj, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int index) {
		
		
	}

	public boolean verificarSenha(String login, String senha) {
		for (int i = 0; i < Bd.listaLogin.size(); i++) {
			if(Bd.listaLogin.get(i).getLogin().equals(login)&&
			Bd.listaLogin.get(i).getSenha().equals(senha)){
				return true;
			}
		}
		return false;
	}

	public char buscarTipo(String login, String senha) {
		for (int i = 0; i < Bd.listaLogin.size(); i++) {
			if(Bd.listaLogin.get(i).getLogin().equals(login)&&
			Bd.listaLogin.get(i).getSenha().equals(senha)){
				return Bd.listaLogin.get(i).getTipo();
			}
		}
		return 'N';
	}

	
	
	
	
}
