/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dao;

import auction.domain.Item;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author geene
 */
public class ItemDAOJPAImpl implements ItemDAO {

    private final EntityManager em;
    EntityManagerFactory emf;

    public ItemDAOJPAImpl() {
        emf = Persistence.createEntityManagerFactory("actionPU");
        em = emf.createEntityManager();
    }

    @Override
    public int count() {
        Query q = em.createNamedQuery("Item.count", Item.class);
        return ((Long) q.getSingleResult()).intValue();
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    public void create(Item item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Item item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    @Override
    public List<Item> findAll() {
        Query query = em.createQuery("SELECT i FROM Item i");
        return (List<Item>) query.getResultList();
    }

    @Override
    public void remove(Item item) {
        em.getTransaction().begin();
        em.remove(em.merge(item));
        em.getTransaction().commit();
    }

    @Override
    public Item find(Long id) {
        Query query = em.createQuery("SELECT * FROM Item i where i.id = " + id);
        return (Item) query.getResultList();
    }

    @Override
    public List<Item> findByDescription(String description) {
        Query query = em.createQuery("SELECT * FROM Item i WHERE i.description = " + description);
        return (List<Item>) query.getResultList();
    }
}
