package com.zuhlke.training.restdemo.dao;

import com.zuhlke.training.restdemo.entity.User;

import javax.persistence.Query;
import java.util.List;

public class UserDao extends PersistenceManager{
    public User getUser(long id){
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

        }catch(Exception ex){
            return null;
        }finally{
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
        }catch(Exception ex){
            return null;
        }finally{
            closeEntityManager();
        }
    }
}
