package com.zuhlke.training.pact.restdemotest;


import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDao extends PersistenceManager {

    public void deleteAll() {
        EntityTransaction transaction = getEntityManager().getTransaction();
        transaction.begin();
        String sql = "DELETE FROM User";
        Query query = getEntityManager().createQuery(sql,User.class);
        query.executeUpdate();
        transaction.commit();
    }

    public User saveUser(User user) {
        EntityTransaction transaction = getEntityManager().getTransaction();
        transaction.begin();
        getEntityManager().persist(user);
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
