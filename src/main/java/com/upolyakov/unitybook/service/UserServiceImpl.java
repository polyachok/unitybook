package com.upolyakov.unitybook.service;

import com.upolyakov.unitybook.model.Role;
import com.upolyakov.unitybook.model.Status;
import com.upolyakov.unitybook.model.User;
import com.upolyakov.unitybook.repository.RoleRepository;
import com.upolyakov.unitybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
 public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;



    //TODO не понятки с passwordEncoder в виде Bean
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        this.create(user);
        return user;
    }

    @Override
    public void create(User user) {
        if (user != null){
            userRepository.save(user);
        }
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        return result;
    }


    //TODO решить как возваращать результат через List или еще как
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    //TODO проверка на пусто
    @Override
    public User getOne(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public boolean update(User user, long id) {
        if (userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    //TODO решить по удалению
    @Override
    public boolean delete(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
