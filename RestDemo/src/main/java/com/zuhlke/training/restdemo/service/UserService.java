package com.zuhlke.training.restdemo.service;

import com.zuhlke.training.restdemo.dao.UserDao;
import com.zuhlke.training.restdemo.entity.User;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    @Inject
    UserDao userDao;

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
        //return Arrays.asList();
    }
}
