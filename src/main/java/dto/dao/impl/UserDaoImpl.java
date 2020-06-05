package dto.dao.impl;

import dto.dao.interfaces.UserDao;
import dto.exception.DataProcessingException;
import dto.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("There was an error inserting "
                    + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> listUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User")
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving user by email ", e);
        }
    }

    @Override
    public User getById(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return (User) session
                    .createQuery("from User where id = :userId")
                    .uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving user by id ", e);
        }
    }
}
