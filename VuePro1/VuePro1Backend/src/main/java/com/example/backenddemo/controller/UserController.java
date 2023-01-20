package com.example.backenddemo.controller;

import com.example.backenddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAll")
    public Object getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public Object login(String username, String password){
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

}
