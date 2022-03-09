package vetor;

public class Principal {

	public static void main(String[] args) {
		
//		//Vetor
//		String[] cores= {"vermelho", "azul", "verde","rosa"};
//		
//		//Listar cores
//		
//		for(int i=0;i<cores.length;i++) {
//			System.out.println(cores[i]);
//		}
		
		//Vetor2
		String[] nome = new String[3];
		
		//Cadastrar Nomes
		nome[0]="Jefferson";
		nome[1]="Jefferson";
		nome[2]="Jefferson";
		
		for (String n : nome) {
			System.out.println(n);
			
		}
	}

}
