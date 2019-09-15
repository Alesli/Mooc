package com.example.Convertor;

import com.example.dto.UserDto;
import com.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto getUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setPassword(user.getPassword());
        userDto.setLogin(user.getLogin());
        userDto.setRole(user.getRole());

        return userDto;
    }

    public User getUser(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        user.setLogin(userDto.getLogin());
        user.setRole(userDto.getRole());

        return user;
    }
}
