package exemplo02;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Curso curso1=new Curso();
		curso1.nome="java";
		curso1.valor=3000;		
		
		Curso curso2=new Curso();
		curso2.nome="C#";
		curso2.valor=2850;
		
		Curso curso3=new Curso();
		curso3.nome="Angular";
		curso3.valor=1700;
		
		
		ArrayList<Curso> listaCurso = new ArrayList<>();
		listaCurso.add(curso1);
		listaCurso.add(curso2);
		listaCurso.add(curso3);
		
		for (int i = 0; i < listaCurso.size(); i++) {
			System.out.println("Nome curso: "+listaCurso.get(i).nome+" Valor: "+listaCurso.get(i).valor);
			
			
		}
		
	}

}
