package com.example.demo.repository;

import com.example.demo.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
    User findUsersByEmailAndPassword(String email, String password);
}
