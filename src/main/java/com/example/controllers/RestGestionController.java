package com.example.controllers;

import com.example.model.Login;
import com.example.model.User;
import com.example.repositories.LoginRepository;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestGestionController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginRepository loginRepository;

    @GetMapping("/users")
    public List<User>getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userRepository.findById(id);
    }
    @GetMapping("/user/searsh/{nom}")
    public List<User> searshUser(@PathVariable("nom") String nom){
        return userRepository.findByNomStartsWith(nom);
    }

    @PostMapping(value= "/login",  consumes = "application/json")
    public Login save(@RequestBody Object login){
        System.out.println(login.toString());
//        return loginRepository.save(login);
        return null;
    }

    @GetMapping(value = "logins")
    public List<Login> getLogins(){
        return loginRepository.findAll();
    }
}
