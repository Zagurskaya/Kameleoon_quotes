package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.UserDTO;

public interface UserService {

    void add(UserDTO user);

    UserDTO loadUserByUsername(String name);

    boolean existsByUsername(String username);
}
