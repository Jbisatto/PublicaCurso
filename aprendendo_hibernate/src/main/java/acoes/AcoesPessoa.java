package acoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Pessoa;

public class AcoesPessoa {

	public static void cadastrar(String nome) {

		Pessoa p = new Pessoa();
		p.setNome(nome);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}

	public static void selecionar() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Pessoa AS p", Pessoa.class);

		List<Pessoa> listaDePessoa = query.getResultList();

		for (Pessoa p : listaDePessoa) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}

		emf.close();
		em.close();
	}

	public static void alterar(int codigo, String nome) {

		Pessoa p = new Pessoa();
		p.setCodigo(codigo);
		p.setNome(nome);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();

		emf.close();
		em.close();

	}

	public static Pessoa filtrar(int codigo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class,codigo);
		em.persist(p);
		em.getTransaction().commit();

		emf.close();
		em.close();
		
		return p;
	}
	
	public static void remover(int codigo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Pessoa p = em.find(Pessoa.class, codigo);
		
		em.remove(p);
		
		em.getTransaction().commit();

		emf.close();
		em.close();
	}

}
