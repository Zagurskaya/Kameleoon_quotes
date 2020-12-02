package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    void add(UserDTO user);

    void delete(Long id);

    UserDTO loadUserByUsername(String name);

    boolean existsByUsername(String username);

//    List<UserDTO> getActionUsersSortedByUserName();
//
//    UserDTO getUserById(Long id);
//
//    String returnPasswordSameAsLogin(UserDTO userDTO);
//
//    UserDTO updateUserRole(Long userId, Long roleId);
//
//    void deleteUsersList(List<Long> ids);
}
