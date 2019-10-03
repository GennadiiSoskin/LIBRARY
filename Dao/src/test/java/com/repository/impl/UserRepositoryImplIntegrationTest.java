package com.repository.impl;


import com.config.DaoConfig;
import com.entity.User;
import com.repository.UserJpaRepository;
import com.repository.UserRepository;
import lombok.Data;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfig.class})
@Transactional

public class UserRepositoryImplIntegrationTest {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserJpaRepository jpaRepository;

    @BeforeClass
    public static void init() {
        System.out.println("Before class");
    }

    @Before
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @After
    public void afterMethod() {
        System.out.println("After method");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Test
    public void saveBook() {
        String login = "Test";
        User user = jpaRepository.findUserByName("Ольга").orElse(new User());
        user.setId(0);
        user.setName(login);
        repository.saveUser(user);
        assertEquals(repository.getUser(login).get().getName(), login);
        System.out.println("first test");
    }


}
