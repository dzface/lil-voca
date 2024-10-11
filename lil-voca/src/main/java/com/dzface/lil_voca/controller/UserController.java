package com.dzface.lil_voca.controller;

import com.dzface.lil_voca.dto.UserRequestDTO;
import com.dzface.lil_voca.dto.UserResponseDTO;
import com.dzface.lil_voca.entitiy.User;
import com.dzface.lil_voca.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

//    @GetMapping("/info")
//    public ResponseEntity<UserResponseDTO> getUsersInfo(@RequestParam UserRequestDTO dto) {
//        return userService.getUsersInfo(dto);
//    }

    @GetMapping("/info/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsersInfo() {
        return userService.getAllUsersInfo();
    }

}
