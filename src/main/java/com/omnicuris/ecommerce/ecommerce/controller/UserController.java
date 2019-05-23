package com.omnicuris.ecommerce.ecommerce.controller;

import com.omnicuris.ecommerce.ecommerce.entity.User;
import com.omnicuris.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping("")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUserById(@PathVariable(value = "id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("User Removed");
    }
}
