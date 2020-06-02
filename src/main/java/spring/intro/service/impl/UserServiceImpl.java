package spring.intro.service.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import spring.intro.dao.interfaces.UserDao;
import spring.intro.model.User;
import org.springframework.stereotype.Service;
import spring.intro.service.interfaces.UserService;

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
}
