package ExemploPrototypeDevMedia;

public class PrototypePatternEx {

	public static void main(String args[]) throws CloneNotSupportedException {

		System.out.println("***Exemplo do padrão Prototype***\n");
		Carro chevrolet = new Chevrolet("Cruze Sport v6");
		chevrolet.preco = 100000;
		Carro ford = new Ford("Focus 2.0");
		ford.preco = 500000;

		Carro bc1;
		// Clone do Objeto Chevrolet
		bc1 = chevrolet.clone();
		System.err.println(chevrolet);
		System.err.println(bc1);

		// Configurando preço que será maior que 100000
		bc1.preco = chevrolet.preco + Carro.setPreco();
		System.out.println("Nome do Carro: " + bc1.getNomeModelo() + 
				",Preço do Carro: " + bc1.preco);

		// Clone do Objeto Ford
		bc1 = ford.clone();
		System.err.println(ford);
		System.err.println(bc1);
		// Configurando preço que será maior que 500000
		bc1.preco = ford.preco + Carro.setPreco();
		System.out.println("Nome do Carro: " + bc1.getNomeModelo() +
				", Preço do Carro: " + bc1.preco);

	}

}
