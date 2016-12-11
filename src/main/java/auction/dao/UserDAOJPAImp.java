package auction.dao;

import auction.domain.User;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class UserDAOJPAImp implements UserDAO {

    private final EntityManager em;
    EntityManagerFactory emf;

    public UserDAOJPAImp() {
        emf = Persistence.createEntityManagerFactory("actionPU");
        em = emf.createEntityManager();
    }

    @Override
    public int count() {
        Query q = em.createNamedQuery("User.count", User.class);
        return ((Long) q.getSingleResult()).intValue();
    }

    public EntityManager getEm() {
        return em;
    }

    
    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void edit(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }


    @Override
    public List<User> findAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        Query q = em.createNamedQuery("User.email", User.class);
        q.setParameter("email", email);
        try {
        return (User) q.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void remove(User user) {
        em.getTransaction().begin();
        em.remove(em.merge(user));
        em.getTransaction().commit();
    }
}
