package com.zuhlke.training.restdemo.dao;

import com.zuhlke.training.restdemo.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDao extends PersistenceManager {

    public void deleteAll() {
        final EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String sql = "DELETE FROM User";
        Query query = entityManager.createQuery(sql,User.class);
        query.executeUpdate();
        transaction.commit();
    }

    public User saveUser(User user) {
        final EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    public User getUser(long id) {
        try {
            String sql = "SELECT c FROM User c where c.id=:id";
            Query query = getEntityManager().createQuery(sql, User.class);
            query.setParameter("id", id);
            @SuppressWarnings("unchecked")
            List<User> users = query.getResultList();
            for (User user : users) {
                System.out.println(user);
            }
            return users.get(0);

        } catch (Exception ex) {
            return null;
        } finally {
            closeEntityManager();
        }
    }

    public List<User> getUsers() {
        try {
            String sql = "SELECT c FROM User c ";
            Query query = getEntityManager().createQuery(sql, User.class);
            @SuppressWarnings("unchecked")
            List<User> users = query.getResultList();
            for (User user : users) {
                System.out.println(user);
            }
            return users;
        } catch (Exception ex) {
            return null;
        } finally {
            closeEntityManager();
        }
    }
}
