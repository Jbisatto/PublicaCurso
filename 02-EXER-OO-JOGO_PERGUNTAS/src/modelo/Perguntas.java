package modelo;

public class Perguntas {

	private String pergunta;
	private String alternativa1;
	private String alternativa2;
	private String alternativa3;
	private String alternativa4;
	private String resposta;
	private String dica;
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getAlternativa1() {
		return alternativa1;
	}
	public void setAlternativa1(String alternativa1) {
		this.alternativa1 = alternativa1;
	}
	public String getAlternativa2() {
		return alternativa2;
	}
	public void setAlternativa2(String alternativa2) {
		this.alternativa2 = alternativa2;
	}
	public String getAlternativa3() {
		return alternativa3;
	}
	public void setAlternativa3(String alternativa3) {
		this.alternativa3 = alternativa3;
	}
	public String getAlternativa4() {
		return alternativa4;
	}
	public void setAlternativa4(String alternativa4) {
		this.alternativa4 = alternativa4;
	}

	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	
	@Override
	public String toString() {
		return "Perguntas=" + pergunta + ", alternativa1=" + alternativa1 + ", alternativa2=" + alternativa2
				+ ", alternativa3=" + alternativa3 + ", alternativa4=" + alternativa4 + ", resposta=" + resposta
				+ ", dica=" + dica+"\n";
	}

}
