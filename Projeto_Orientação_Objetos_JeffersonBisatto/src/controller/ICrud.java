package controller;


public interface ICrud<T> {

	public void cadastrar(T obj);

	public boolean remover(int index);


	public void alterar(T obj, int index);

}
