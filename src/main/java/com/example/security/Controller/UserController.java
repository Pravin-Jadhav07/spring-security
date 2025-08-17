package com.example.security.Controller;

import com.example.security.Model.MyUser;
import com.example.security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public MyUser register(@RequestBody MyUser myUser) {

        MyUser user = userService.save(myUser);
        return user;
    }

    @GetMapping("/all")
    public List<MyUser> getAllUsers() {
        return userService.findAll();
    }


//    @GetMapping("/{id}")
//    public MyUser getUserById(@PathVariable Long id) {
//        return userService.findById(id);
//    }

//    @GetMapping("/{id}")
//    public MyUser getUserById(@PathVariable Long id) {
//        return userService.findById(id);
//    }

//    @PutMapping("/{id}")
//    public MyUser updateUser(@PathVariable Long id, @RequestBody MyUser updatedUser) {
//        return userService.update(id, updatedUser);
//    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "User with ID " + id + " deleted successfully!";
    }
}
