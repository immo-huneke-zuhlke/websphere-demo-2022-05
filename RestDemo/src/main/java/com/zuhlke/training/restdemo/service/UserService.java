package com.zuhlke.training.restdemo.service;

import com.zuhlke.training.restdemo.dao.UserDao;
import com.zuhlke.training.restdemo.entity.User;

import javax.inject.Inject;
import java.util.List;

public class UserService {
    @Inject
    UserDao userDao;

    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
