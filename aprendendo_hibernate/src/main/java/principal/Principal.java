package principal;

import acoes.AcoesPessoa;
import entidade.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		AcoesPessoa ap = new AcoesPessoa();
//		ap.cadastrar("Jefferson");
//		ap.selecionar();
//		ap.alterar(1, "Jefferson Bisatto");
//		
//		Pessoa p = AcoesPessoa.filtrar(1);
//		System.out.println(p.getCodigo());
//		System.out.println();
		AcoesPessoa.remover(1);
		
	}
	
}
