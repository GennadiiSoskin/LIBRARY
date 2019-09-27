package com.repository.impl;

import com.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepositoryImpl implements com.repository.UserRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
