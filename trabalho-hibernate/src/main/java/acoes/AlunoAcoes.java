package acoes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

import modelo.Aluno;
import validador.Arrendondador;


public class AlunoAcoes {
	
	public static void cadastrar(Aluno aluno) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho_hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}

	public static List<Aluno> selecionar() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho_hibernate");

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p FROM Aluno AS p", Aluno.class);

		List<Aluno> listaDeAluno = query.getResultList();

		emf.close();
		em.close();
		
		return listaDeAluno;
	}

	public static void alterar(Aluno aluno) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho_hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();

		emf.close();
		em.close();

	}

	public static Aluno filtrar(int codigo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho_hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Aluno a = em.find(Aluno.class,codigo);
		em.persist(a);
		em.getTransaction().commit();

		emf.close();
		em.close();
		
		return a;
	}
	
	public static void remover(int codigo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho_hibernate");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Aluno a = em.find(Aluno.class, codigo);
		
		em.remove(a);
		
		em.getTransaction().commit();

		emf.close();
		em.close();
	}
	
}
