package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void save(User user);

    void update(User user);

    Optional<User> findById(long id);

    List<User> findAll();

    void deleteById(int id);
}
