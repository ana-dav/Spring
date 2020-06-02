package spring.intro.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.intro.dao.interfaces.UserDao;
import spring.intro.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
            sessionFactory.openSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        return sessionFactory
                .openSession()
                .createQuery("from User")
                .getResultList();
    }
}
