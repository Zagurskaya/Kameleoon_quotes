package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.Util.UserUtil;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROFILE;

@Controller
public class UserController {

    private final UserService userService;
    private final UserUtil userUtil;


    @Autowired
    public UserController(UserService userService, UserUtil userUtil) {
        this.userService = userService;
        this.userUtil = userUtil;
    }

    @GetMapping(URL_PROFILE)
    public String getAdminPage(Model model) {
        UserDTO user = userUtil.getActualUser();
        String FullName = user.getFirstName() + " " + user.getLastName();
        model.addAttribute("FullName", FullName);
        return URL_PROFILE;
    }
}
