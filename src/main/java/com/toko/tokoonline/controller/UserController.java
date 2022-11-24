package com.toko.tokoonline.controller;

import com.toko.tokoonline.model.User;
import com.toko.tokoonline.response.ResponseHelper;
import com.toko.tokoonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
@Autowired
    private UserService userService;

    @GetMapping("/all")
    public Object getAllUser(){
        return ResponseHelper.ok(userService.getAllUser()) ;
    }

    @GetMapping("/{id}")
    public Object  getUser(@PathVariable("id") Long id) {
        return ResponseHelper.ok(userService.getUser(id)) ;
    }

    @PostMapping
    public Object addUser(@RequestBody User user) {
        return ResponseHelper.ok( userService.addUser(user)) ;
    }

    @PutMapping("/{id}")
    public Object editUserById(@PathVariable("id") Long No, @RequestBody User user) {
        return ResponseHelper.ok(  userService.editUser(No, user.getUsername(), user.getEmail(), user.getAge(), user.getAddres(), user.getPhoneNumber())) ;
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) { userService.deleteUserById(id);}
}
