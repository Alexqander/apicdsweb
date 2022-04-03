package com.cds.mx.apicds.user.controller;

import com.cds.mx.apicds.security.controller.UserDTO;
import com.cds.mx.apicds.user.model.User;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody UserDTO userDTO){
        return service.save(new User(
                userDTO.getUsername(),
                encoder.encode(userDTO.getPassword()),
                userDTO.getPerson(),
                userDTO.getRoles()
        ));
    }


}
