package com.gmail.zagurskaya.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    private String password;
    @NotNull
    @Size(min = 3, max = 50)
    private String lastName;
    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;

    private String role;

}
