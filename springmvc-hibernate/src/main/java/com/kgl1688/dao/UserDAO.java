package com.kgl1688.dao;

import com.kgl1688.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        String hsql = "from user";

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(hsql);
        return query.list();
    }

    public User createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    public void updateUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.update(user);

    }

    public void delUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void delUser(int user_id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, user_id);
        delUser(user);
    }
}
