package matriz;

public class Principal {

	public static void main(String[] args) {
		
		String[][] dados= {
				{"Alice","Blumenau"},
				{"Caio","Curitiba"},
				{"Isabela","S?o Paulo"}
		};
		
//		for(int i=0;i<dados.length;i++) {
//			System.out.println(dados[i][0]);
//			System.out.println(dados[i][1]);
//			System.out.println();
//		}
		
		//FOREACH
		
		for(String[] n: dados) {
			System.out.println(n[0]);
			System.out.println(n[1]);
			System.out.println();
		}
		
	}

}
