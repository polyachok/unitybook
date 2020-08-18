package com.upolyakov.unitybook.repository;

import com.upolyakov.unitybook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
