package com.upolyakov.unitybook.service;

import com.upolyakov.unitybook.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    void create(User user);

    User findByUsername(String username);

    List<User> getAll();

    User getOne(long id);

    boolean update(User user, long id);

    boolean delete(long id);
}
