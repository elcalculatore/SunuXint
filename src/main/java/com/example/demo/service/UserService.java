package com.example.demo.service;

import com.example.demo.modele.User;

import java.util.List;

public interface UserService {
    List<User> lire();
    User inscrire(User user) throws Exception;
    User connecter(User user);
    User modifier(Long id, User user);
    String supprimer(Long id);
}
