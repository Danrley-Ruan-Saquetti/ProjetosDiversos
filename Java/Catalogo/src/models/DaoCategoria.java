package models;

import entities.Categoria;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.NoResultException;

public class DaoCategoria extends Dao {

    public boolean inserir(Categoria c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean remover(Categoria c) {
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

    public boolean editar(Categoria c) {
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

    public Categoria selecionar(String nome) {
        try {
            return (Categoria) em.createQuery("select c from Categoria c where c.nome = :nome").setParameter("nome", nome).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Categoria> listar() {
        return em.createQuery("select c from Categoria c").getResultList();
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
