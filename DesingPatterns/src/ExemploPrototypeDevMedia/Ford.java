package ExemploPrototypeDevMedia;

public class Ford extends Carro {
    public Ford(String m)
    {
          nomeModelo = m;
    }

    @Override
    public Carro clone() throws CloneNotSupportedException
    {
          return (Ford)super.clone();
    }
}
