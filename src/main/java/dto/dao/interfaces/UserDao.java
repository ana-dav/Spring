package dto.dao.interfaces;

import dto.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);
}
