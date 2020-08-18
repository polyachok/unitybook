package com.upolyakov.unitybook.service;

import com.upolyakov.unitybook.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void create(User user);

    List<User> getAll();

   User getOne(int id);

    boolean update(User user, int id);

    boolean delete(int id);
}
