package dto.service.impl;

import dto.dao.interfaces.UserDao;
import dto.model.User;
import dto.service.interfaces.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getById(Long userId) {
        return userDao.getById(userId);
    }
}
