package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public Optional<User> findById(long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void deleteById(int id) {
        Optional<User> user = findById(id);
        user.ifPresent(em::remove);
    }
}
