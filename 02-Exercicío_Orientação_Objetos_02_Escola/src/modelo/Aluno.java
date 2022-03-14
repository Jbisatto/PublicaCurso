package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
//	 Nome, turma, aniversário (dia/mês/ano) e telefone;

	private String nome;
	private String turma;
	private Date dataNascimento;
	private int telefone;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return "Nome=" + nome + ", turma=" + turma + ", dataNascimento=" +formato.format(dataNascimento) + ", telefone="
				+ telefone + "\n";
	}

}
