package modelo;

public class Conta {

	private int numeroConta;
	private String tipoConta;
	private String correntiista;
	private double saldo;

	
	
	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Conta() {
		this.numeroConta=238578;
		this.tipoConta="Conta Corrente";
		this.correntiista="Jefferson Bisatto";
		this.saldo=1000;

	}


	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getCorrentiista() {
		return correntiista;
	}

	public void setCorrentiista(String correntiista) {
		this.correntiista = correntiista;
	}




}
