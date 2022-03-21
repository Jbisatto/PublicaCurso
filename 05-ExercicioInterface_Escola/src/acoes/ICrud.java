package acoes;

import java.util.List;

public interface ICrud<t> {

	public void cadastrar(t obj);
	public List<t> lista();
	public void alterar(t obj,  int index);
	public void remover(int index);
	
	
}
