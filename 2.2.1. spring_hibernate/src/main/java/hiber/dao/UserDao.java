package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> getUsers();

   List<User> findUser(String model, int series);
}
