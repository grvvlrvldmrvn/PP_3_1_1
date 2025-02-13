package web.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.example.dao.UserDAO;
import web.example.model.User;

import java.util.List;

@Service
@Repository
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void removeUserById(int id) {
        userDAO.removeUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }
}