package com.example.controller.management;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class LoginController {

    @Autowired
    private UserService userService;

    //    http://localhost:8080/api/user/login/{userLogin}
    @GetMapping("/login/{userLogin}")
    public UserDto findUserByLogin(@PathVariable() String userLogin) {
        User user = userService.findUserByLogin(userLogin);
        return null;
    }
}
