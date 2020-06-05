package spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.dao.interfaces.UserDao;
import spring.model.User;
import spring.service.interfaces.UserService;

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
