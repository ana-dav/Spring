package dto.service.interfaces;

import dto.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);
}
