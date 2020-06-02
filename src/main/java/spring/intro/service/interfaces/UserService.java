package spring.intro.service.interfaces;

import java.util.List;
import spring.intro.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
