package modelo;

import java.util.Date;

public class Jogador {
//	Implemente um ranking para exibir o nome dos jogadores,
//	data e hora que jogou, além da quantidade de acertos,
//	ordene a exibição pela quantidade de acertos
	private String nomeJogador;
	private Date hora;
	private int qtdAcertos;
	private int qtdErros;
	
	
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public int getQtdAcertos() {
		return qtdAcertos;
	}
	public void setQtdAcertos(int qtdAcertos) {
		this.qtdAcertos = qtdAcertos;
	}
	public int getQtdErros() {
		return qtdErros;
	}
	public void setQtdErros(int qtdErros) {
		this.qtdErros = qtdErros;
	}
	
	
}
