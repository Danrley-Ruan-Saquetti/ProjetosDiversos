
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoJogador {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CassinoPU");
    private EntityManager em = emf.createEntityManager();
    
    public boolean inserir(Jogador j) {
        try {
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean excluir(Jogador j) {
        try {
            em.getTransaction().begin();
            em.remove(j);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean editar(Jogador j) {
        try {
            em.getTransaction().begin();
            em.merge(j);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public Jogador selecionarCodigo(String senha) {
        try {
            Query consulta = em.createQuery("select j from Jogador j where j.senha = :senha");
            consulta.setParameter("senha", senha);
            return (Jogador) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Jogador selecionarNome(String nome) {
        try {
            Query consulta = em.createQuery("select j from Jogador j where j.nome = :nom");
            consulta.setParameter("nom", nome);
            return (Jogador) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
