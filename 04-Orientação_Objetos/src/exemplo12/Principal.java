package exemplo12;

public class Principal {

	public static void main(String[] args) {
		
		Calculos desenvolvedor = new Desenvolvedor();
		desenvolvedor.valeAlimentacao(200);
		desenvolvedor.valeTransporte(1000);

		Calculos analista = new Analista();
		analista.valeAlimentacao(200);
		analista.valeTransporte(1000);
	}

}
