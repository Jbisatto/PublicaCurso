package exemplo12;

public class Analista extends Calculos {
	
	@Override
	public void valeTransporte(double salario) {
		System.out.println("Vale Transporte analista: "+(salario*0.1));
	}
	@Override
	public void valeAlimentacao(double salario) {
		System.out.println("Vale alimenta��o analista: "+(salario*0.2));
	}

}
