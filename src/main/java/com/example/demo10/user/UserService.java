package com.example.demo10.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserInfo> getUsers() {
        return userRepository.findAll();
    }
    public UserInfo addUser(UserInfo user) {
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id)
        ;
    }

    public UserInfo editUser(UserInfo userInfo,long id) {
        return userRepository.findById(id).map(user -> {
                    user.setUsername(user.getUsername());
                    user.setName(user.getName());
                    user.setEmail(user.getEmail());
                    user.setPassword(user.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    userInfo.setId(id)
                    ;
                    return userRepository.save(userInfo);
                });
    }
}


