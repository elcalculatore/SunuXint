package com.example.demo.controlleur;

import com.example.demo.modele.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserControlleur {
    private final UserService userService;
    @PostMapping("/registre")
    public User create(@RequestBody User user) throws Exception {
        return userService.inscrire(user);
    }
    @PostMapping("/login")
    public User log(@RequestBody User user){
        return userService.connecter(user);
    }
    @PostMapping("/update/{id1}")
    public  User update(@RequestParam Long id, @RequestBody User user){
        return  userService.modifier(id,user);
    }
    @PostMapping("/getAllUser")
    public List<User> readAll(){
        return userService.lire();
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@RequestParam Long id){
        return  userService.supprimer(id);
    }
}
