package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getUsers();

    List<User> findUser(String model, int series);
}
