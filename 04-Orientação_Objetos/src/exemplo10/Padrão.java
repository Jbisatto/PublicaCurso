package exemplo10;

public abstract class Padrão {

	public abstract int soma(int n1, int n2);
	
	public abstract double subtracao(int n1,int n2);
	
	public abstract double multiplicacao(int n1,int n2);
	
	public abstract double divisao(int n1,int n2);
	
	public double media(double n1,double n2) {
		return (n1+n2)/2;
	}
	
	
}
