package ExemploPrototypeDevMedia;

public class Chevrolet extends Carro {
    public Chevrolet(String m)
    {
          nomeModelo = m;
    }

    @Override
    public Carro clone() throws CloneNotSupportedException
    {
          return (Chevrolet)super.clone();
    }
}
