package com.example.service;

import com.example.DTO.UserDTO;
import com.example.model.Login;
import com.example.model.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // trensfer User to UserDTO
    public UserDTO toUserDTO(User user){
        String nom = user.getNom();
        List<String> logins = user.getLogins().
                                    stream().
                                    map(Login::getLogin).
                                    collect(Collectors.toList());
        return new UserDTO(nom,logins);
    }

    public List<UserDTO> getUsersDTO() {
        return userRepository.findAll().
                            stream().
                            map(this::toUserDTO).
                            collect(Collectors.toList());
    }
}
