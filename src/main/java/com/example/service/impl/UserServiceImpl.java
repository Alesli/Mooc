package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOneById(Long id) {
        return Optional.ofNullable(userRepository.findOneById(id)).orElse(null);
    }

    @Override
    public String findLogin(String password, String login) {
        return null;
    }

    @Override
    public User findOneByLogin(String login) {
        return Optional.ofNullable(userRepository.findOneByLogin(login)).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null){
            return userRepository.save(user);
        } else return update(user);
    }

    @Override
    public User update(User user) {
        if (user.getId()!= null){
          User result = User.builder()
                  .fullName(user.getFullName())
                  .password(user.getPassword())
                  .login(user.getLogin())
                  .role(user.getRole())
                  .build();
            return userRepository.save(result);
        } else return save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
