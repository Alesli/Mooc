package com.example.controller.management;

import com.example.Convertor.UserConverter;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/management")
public class ManageUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    //    http://localhost:8080/api/management/user/{userId}
    @GetMapping("/{userId}")
    public UserDto findOneUserById(@PathVariable() Long userId) {
        User result = userService.findOneById(userId);
        return userConverter.getUserDto(result);
    }

    //    http://localhost:8080/api/management/users
    @GetMapping("/users")
    public List<UserDto> findAllUsers() {
        List<User> result = userService.findAll();
        return result.stream()
                .map(userConverter::getUserDto)
                .collect(Collectors.toList());
    }

    //    http://localhost:8080/api/management/register
    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = userConverter.getUser(userDto);
        User result = userService.save(user);
        return userConverter.getUserDto(result);
    }

    //    http://localhost:8080/api/management/user/{userId}
    @PutMapping("/user/{userId}")
    public UserDto updateUser(@PathVariable() Long userId) {
        User user = userService.findOneById(userId);
        User result = userService.update(user);
        return userConverter.getUserDto(result);
    }

    //    http://localhost:8080/api/management/user/{userId}
    @DeleteMapping("/user/{userId}")
    public void removeUser(@PathVariable() Long userId) {
        userService.delete(userId);
    }
}