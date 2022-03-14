package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

//	Cadastrar - Nome, e-mail, telefone, nascimento, estado e cidade;
	private String nome;
	private String email;
	private int telefone;
	private Date dataNacimento;
	private String cidade;
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emial) {
		this.email = emial;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Date getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		return "Nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", dataNacimento="
				+ formato.format(dataNacimento) + ", cidade=" + cidade + ", estado=" + estado;
	}
	

}
