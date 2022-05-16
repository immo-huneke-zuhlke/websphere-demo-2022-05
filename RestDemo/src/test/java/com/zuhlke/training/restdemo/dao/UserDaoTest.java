package com.zuhlke.training.restdemo.dao;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.zuhlke.training.restdemo.entity.User;
import com.zuhlke.training.restdemo.service.UserService;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserDaoTest {

    private UserDao userDao = new UserDao();

    @Test
    public void shouldSaveUserIfNew() {
        Faker faker = new Faker();
        final Name fakeName = faker.name();
        final String firstName = fakeName.firstName();
        final String lastName = fakeName.lastName();
        String name = format("%s %s", firstName, lastName);
        String email = format("%s.%s@gmail.com", firstName, lastName);
        User newUser = new User(0, name, email);
        User savedUser = userDao.saveUser(newUser);
        assertNotEquals(0, savedUser.getId());
        assertEquals(newUser.getName(), savedUser.getName());
    }
}
