package com.example.demo.service;

import com.example.demo.modele.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.lang.Exception;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User inscrire(User user) throws Exception {
        String email = user.getEmail();
        if (email != null && !"".equals(email)) {
            User insUser = userRepository.findUserByEmail(email);
            if (insUser != null) throw new Exception("This user is already exist");

            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User connecter(User user) {
        User oldUSer = userRepository.findUsersByEmailAndPassword(user.getEmail(), user.getPassword());
        return oldUSer;
    }

    @Override
    public User modifier(Long id,User user) {
        return userRepository.findById(id)
                .map(pro->{
                    pro.setNom(user.getNom());

                    return userRepository.save(pro);
                }).orElseThrow(() -> new RuntimeException("Produit non trouve"));

    }

    @Override
    public String supprimer(Long id) {
        return "User supprime";
    }
}
