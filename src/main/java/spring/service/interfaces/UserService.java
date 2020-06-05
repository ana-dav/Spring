package spring.service.interfaces;

import java.util.List;
import spring.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);
}
