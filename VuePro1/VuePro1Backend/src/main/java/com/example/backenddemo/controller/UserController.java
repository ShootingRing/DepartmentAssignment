package com.example.backenddemo.controller;

import com.example.backenddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
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
