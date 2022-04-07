package com.financial.analysis.controller.user;

import com.financial.analysis.model.request.UserRequest;
import com.financial.analysis.model.response.user.UserResponse;
import com.financial.analysis.service.user.UserService;
import com.financial.analysis.service.user.impl.CustomUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user")
    public UserResponse createUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @GetMapping(value = "/users")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/user/{id}")
    public UserResponse getUserByID(@PathVariable Long id) throws Exception{
        return userService.getUser(id);
    }

    @PutMapping(value = "/user")
    public UserResponse updateUser(@RequestBody UserRequest request) throws Exception{
        return userService.updateUser(request);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUserByID(@PathVariable Long id) throws RuntimeException {
        userService.deleteUser(id);
    }



}
