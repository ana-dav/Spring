package spring.intro.dao.interfaces;

import java.util.List;
import java.util.Optional;
import spring.intro.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
