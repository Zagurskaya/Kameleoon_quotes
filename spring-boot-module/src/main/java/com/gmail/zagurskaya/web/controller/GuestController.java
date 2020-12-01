package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.QuotesService;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.util.UserUtil;
import com.gmail.zagurskaya.service.model.QuoteDTO;
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
    private final QuotesService quotesService;
    private final UserUtil userUtil;


    public GuestController(UserService userService, QuotesService quotesService, UserUtil userUtil) {
        this.userService = userService;
        this.quotesService = quotesService;
        this.userUtil = userUtil;
    }

    @GetMapping(URL_QUOTES)
    public String getQuotesInAdminPage(Model model) {
        List<QuoteDTO> quotes = quotesService.getQuotes();
        List<UserDTO> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("quotes", quotes);
        return PATH_QUOTES;
    }
}
