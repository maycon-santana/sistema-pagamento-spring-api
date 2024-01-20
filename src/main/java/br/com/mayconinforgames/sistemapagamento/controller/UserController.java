package br.com.mayconinforgames.sistemapagamento.controller;

import br.com.mayconinforgames.sistemapagamento.dto.UserRequest;
import br.com.mayconinforgames.sistemapagamento.entity.User;
import br.com.mayconinforgames.sistemapagamento.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest) {
        User user = userRequest.toModel();
        User userSaved = userService.registerUser(user);
        return ResponseEntity.ok().body(userSaved);
    }

}
