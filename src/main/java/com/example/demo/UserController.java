package com.example.demo;

import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private Mapper mapper;

    @PostMapping("/")
    public ResponseEntity<UserDTO> save(@RequestBody User data) {
        User user = service.save(data);
        UserDTO dto = mapper.map(user, UserDTO.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> info(@PathVariable("id") long userId) {
        User user = service.getById(userId);
        UserDTO dto = mapper.map(user, UserDTO.class);
        return ResponseEntity.ok(dto);
    }
}
