package com.works.restjpa.restcontrollers;

import com.works.restjpa.entities.Users;
import com.works.restjpa.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    final UserService userService;
    final HttpServletRequest request;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Users user){
        return userService.save(user);
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Users user){
        if(userService.login(user) != null){
            request.getSession().setAttribute("user",user.getEmail());
        }
        return userService.login(user);
    }
}
