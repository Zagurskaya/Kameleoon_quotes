package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_ACCOUNT;
import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_PROFILE_POST;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_ACCOUNT;


@Controller
@RequestMapping(URL_ACCOUNT)
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAccountPage(Model model) {
        return PATH_ACCOUNT;
    }

    @PostMapping()
    public String postUpdateQuote(@ModelAttribute(value = "user") UserDTO userDTO, Model model) {
        if (userService.existsByUsername(userDTO.getUsername())) {
            model.addAttribute("error", " exists user with this Username");
            return PATH_ACCOUNT;
        }
        userService.add(userDTO);
        return PATH_PROFILE_POST;
    }
}
