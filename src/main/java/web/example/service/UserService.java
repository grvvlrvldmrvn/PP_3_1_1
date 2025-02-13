package web.example.service;

import web.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User show(int id);

    void saveUser(User user);

    void removeUserById(int id);

    void updateUser(int id, User user);
}