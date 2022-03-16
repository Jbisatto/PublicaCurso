package model;

public class Vendedor extends Funcionario implements IComissao{

	@Override
	public double comissao(double valor) {
		// TODO Auto-generated method stub
		return valor*0.05;
	}

}
