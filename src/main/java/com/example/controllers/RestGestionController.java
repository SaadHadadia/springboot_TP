package com.example.controllers;

import com.example.DTO.UserDTO;
import com.example.model.Login;
import com.example.model.User;
import com.example.repositories.LoginRepository;
import com.example.repositories.UserRepository;
import com.example.service.UserService;
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

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDTO>getUsersDTO(){
        return userService.getUsersDTO();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userRepository.findById(id);
    }
    @GetMapping("/user/searsh/{nom}")
    public List<User> searshUser(@PathVariable("nom") String nom){
        return userRepository.findByNomStartsWith(nom);
    }

    @PostMapping(value= "/login")
    public Login save(@RequestBody Login login){
        return loginRepository.save(login);
    }

    @GetMapping(value = "logins")
    public List<Login> getLogins(){
        return loginRepository.findAll();
    }
}
