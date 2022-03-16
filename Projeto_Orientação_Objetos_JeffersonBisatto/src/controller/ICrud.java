package controller;

import java.util.List;

public interface ICrud {
	
	public void cadastrar(Object obj);
	public void remover(int index);
	public List<Object> listarTodos();
	public void alterar(Object obj);

}
