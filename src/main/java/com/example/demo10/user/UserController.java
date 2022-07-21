package com.example.demo10.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserService userService;



    @GetMapping("get")
    public List<UserInfo> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("user")
    public ResponseEntity<UserInfo> create(@RequestBody UserInfo newUser) {
        UserInfo user = userService.addUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @DeleteMapping("user")
    public ResponseEntity<UserInfo> delete(@RequestParam long id) {
        userService.deleteUser(id);
        ;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserInfo> edit(@RequestBody UserInfo user, @PathVariable long id) {
        UserInfo changeduser = userService.editUser(user,id);
        return new ResponseEntity<>(changeduser, HttpStatus.OK);

    }






}
