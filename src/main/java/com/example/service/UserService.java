package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    User findOneById(Long id);

    User findOneByLogin(String login);

    List<User> findAll();

    User save(User user);

    User update(User user);

    boolean delete(Long id);
}
