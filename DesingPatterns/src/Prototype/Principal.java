package Prototype;

public class Principal {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Pessoa jefferson = new Pessoa("Jefferson",34);
		
		Pessoa joaquim = jefferson.clone();
		
		System.out.println(jefferson);
		System.out.println(joaquim);

	}

}
