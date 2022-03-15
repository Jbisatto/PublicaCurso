package modelo;

public class Login {
	
	private int id_conta;
	private String login;
	private int senha;
	
	public Login() {
		this.id_conta=0;
		this.login="bisatto";
		this.senha=666;
	}

	public boolean autenticacao(String log, int senha2) {
		if(this.login.equals(log)&&this.senha==senha2) {
			return true;
		}
		return false;
	}

	public int buscarIdConta(String log, int senha2) {
		
		return this.id_conta;
	}

	
	
}
