package web.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.example.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void updateUser(int id, User user) {
        User existingUser = entityManager.find(User.class, id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            entityManager.merge(existingUser);
        }
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
}