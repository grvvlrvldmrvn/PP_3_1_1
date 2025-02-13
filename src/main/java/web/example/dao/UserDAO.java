package web.example.dao;


import web.example.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    void removeUserById(int id);

    List<User> getUsers();

    void updateUser(int id, User user);

    User show(int id);
}