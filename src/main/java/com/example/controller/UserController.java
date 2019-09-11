package com.example.controller;

import com.example.entity.User;
import com.example.service.CourseService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    //    http://localhost:8080/api/user/findById/{userId}
    @GetMapping("/findById/{userId}")
    public ResponseEntity<User> findOneBookById(@PathVariable("userId") Long userId) {
        User result = userService.findOneById(userId);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/user/findByLogin/{userLogin}
    @GetMapping("/findById/{userLogin}")
    public ResponseEntity<User> findOneBookBy(@PathVariable("userLogin") String userLogin) {
        User result = userService.findOneByLogin(userLogin);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/user/findAll
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> result = userService.findAll();
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/user/register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User result = userService.save(user);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/user/remove/{userId}
    @GetMapping("/remove/{userId}")
    public ResponseEntity removeUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
