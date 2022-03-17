package controller;

import java.util.List;

public interface ICrud<T> {

	public void cadastrar(T obj);

	public void remover(int index);


	public void alterar(T obj, int index);

}
