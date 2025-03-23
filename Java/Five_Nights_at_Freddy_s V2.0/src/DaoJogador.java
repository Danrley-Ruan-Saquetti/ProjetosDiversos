
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class DaoJogador {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Five_Nights_at_Freddy_s_V2.0PU");
    private EntityManager em = emf.createEntityManager();

    public boolean inserir(Jogador jogador) {
        try {
            em.getTransaction().begin();
            em.persist(jogador);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean excluir(Jogador c) {
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean editar(Jogador c) {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public void fechar() {
        em.close();
        emf.close();
    }

    public List<Jogador> listar() {
        return em.createQuery("select c from Jogador c").getResultList();
    }
}
