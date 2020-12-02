package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.QuoteService;
import com.gmail.zagurskaya.service.StatisticService;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.util.UserUtil;
import com.gmail.zagurskaya.service.model.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_QUOTES;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_CONS;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PROS;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_QUOTES;

@Controller
public class GuestController {
    private final QuoteService quoteService;
    private final StatisticService statisticService;
    private static final int PROS = 1;
    private static final int CONS = 0;

    @Autowired
    public GuestController(QuoteService quoteService, StatisticService statisticService) {
        this.quoteService = quoteService;
        this.statisticService = statisticService;
    }

    @GetMapping(URL_QUOTES)
    public String getQuotesInAdminPage(Model model) {
        List<QuoteDTO> quotes = quoteService.getQuotes();
        model.addAttribute("quotes", quotes);
        return PATH_QUOTES;
    }

    @PostMapping(URL_PROS)
    public String postQuotePros(@RequestParam("id") Long quoteId, Model model) {
        statisticService.addStatisticByQuoteId(PROS, quoteId);
        List<QuoteDTO> quotes = quoteService.getQuotes();
        model.addAttribute("quotes", quotes);
        return PATH_QUOTES;
    }

    @PostMapping(URL_CONS)
    public String postQuoteCons(@RequestParam("id") Long quoteId, Model model) {
        statisticService.addStatisticByQuoteId(CONS, quoteId);
        List<QuoteDTO> quotes = quoteService.getQuotes();
        model.addAttribute("quotes", quotes);
        return PATH_QUOTES;
    }
}
