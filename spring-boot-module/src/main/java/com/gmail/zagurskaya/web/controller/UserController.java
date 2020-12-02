package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.QuoteService;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.model.QuoteDTO;
import com.gmail.zagurskaya.service.model.UserDTO;
import com.gmail.zagurskaya.service.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_NEW_QUOTE;
import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_PROFILE;
import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_PROFILE_POST;
import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_QUOTE;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROFILE;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROFILE_ADD;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROFILE_DELETE;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROFILE_UPDATE;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROFILE_UPDATE_ID;

@Controller
@RequestMapping(URL_PROFILE)
public class UserController {

    private final UserService userService;
    private final QuoteService quoteService;
    private final UserUtil userUtil;


    @Autowired
    public UserController(UserService userService, QuoteService quoteService, UserUtil userUtil) {
        this.userService = userService;
        this.quoteService = quoteService;
        this.userUtil = userUtil;
    }

    @GetMapping()
    public String getUserPage(Model model) {
        UserDTO user = userUtil.getActualUser();
        List<QuoteDTO> quoteDTOS = quoteService.getQuotesByUserId(user.getId());
        String FullName = user.getFirstName() + " " + user.getLastName();
        model.addAttribute("FullName", FullName);
        model.addAttribute("quotes", quoteDTOS);
        return PATH_PROFILE;
    }

    @PostMapping(URL_PROFILE_DELETE)
    public String postDeleteQuotes(
            @RequestParam("id") Long id,
            Model model
    ) {
        quoteService.delete(id);
        return PATH_PROFILE_POST;
    }

    @PostMapping(URL_PROFILE_UPDATE)
    public String postUpdateQuote(@RequestParam("id") Long quoteId, Model model) {
        return PATH_PROFILE_POST + "/" + quoteId;
    }

    @GetMapping(URL_PROFILE_UPDATE_ID)
    public String getUpdateQuote(@PathVariable("id") Long quoteId, Model model) {
        QuoteDTO quoteDTOS = quoteService.getQuoteById(quoteId);
        model.addAttribute("quote", quoteDTOS);
        return PATH_QUOTE;
    }

    @PostMapping(URL_PROFILE_UPDATE_ID)
    public String postUpdateQuote(@RequestParam("id") Long quoteId,
                                  @ModelAttribute(value = "quote") QuoteDTO quoteDTO,
                                  Model model) {
        UserDTO user = userUtil.getActualUser();
        quoteDTO.setUser(user);
        quoteService.update(quoteDTO);
        return PATH_PROFILE_POST;
    }

    @GetMapping(URL_PROFILE_ADD)
    public String getAddNewQuote(Model model) {
        return PATH_NEW_QUOTE;
    }

    @PostMapping(URL_PROFILE_ADD)
    public String postAddNewQuote(@ModelAttribute(value = "quote") QuoteDTO quoteDTO,
                                  Model model) {
        UserDTO user = userUtil.getActualUser();
        quoteDTO.setUser(user);
        quoteService.add(quoteDTO);
        return PATH_PROFILE_POST;
    }
}
