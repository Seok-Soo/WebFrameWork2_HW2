package com.example.hellospringbootsecurity.service;

import com.example.hellospringbootsecurity.entity.MyRole;
import com.example.hellospringbootsecurity.entity.MyUser;

import java.util.List;

public interface RegistrationService {
    MyUser createUser(MyUser user, List<MyRole> userRoles);

    boolean checkEmailExists(String email);

    MyRole findByRolename(String rolename);
}