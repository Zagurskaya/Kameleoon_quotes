package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.ReviewsService;
import com.gmail.zagurskaya.service.RoleService;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.Util.UserUtil;
import com.gmail.zagurskaya.service.model.ReviewsDTO;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_QUOTES;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_QUOTES;

@Controller
public class GuestController {
    private final UserService userService;
    private final RoleService roleService;
    private final ReviewsService reviewsService;
    private final UserUtil userUtil;


    public GuestController(UserService userService, RoleService roleService, ReviewsService reviewsService, UserUtil userUtil) {
        this.userService = userService;
        this.roleService = roleService;
        this.reviewsService = reviewsService;
        this.userUtil = userUtil;
    }

    @GetMapping(URL_QUOTES)
    public String getReviewsInAdminPage(Model model) {
        List<ReviewsDTO> reviews = reviewsService.getReviews();
        List<UserDTO> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("reviews", reviews);
        return PATH_QUOTES;
    }
}
