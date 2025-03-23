package models;

import entities.Cliente;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DaoCliente extends Dao {

    public boolean inserir(Cliente c) {
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

    public boolean remover(Cliente c) {
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

    public boolean editar(Cliente c) {
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

    public Cliente selecionar(String cpf) {
        try {
            return (Cliente) em.createQuery("select c from Cliente c where c.cpf = :cp").setParameter("cp", cpf).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c").getResultList();
    }

    public void fechar() {
        em.close();
        emf.close();
    }
}
