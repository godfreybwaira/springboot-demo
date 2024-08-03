package com.example.demo;

import lombok.Data;

@Data
public class UserDTO {
    private String email, name;
    private boolean active;
}
