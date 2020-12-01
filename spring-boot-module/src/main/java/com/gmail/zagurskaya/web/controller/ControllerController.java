//package com.gmail.zagurskaya.web.controller;
//
//import com.gmail.zagurskaya.service.CurrencyService;
//import com.gmail.zagurskaya.service.DutiesService;
//import com.gmail.zagurskaya.service.RateCBService;
//import com.gmail.zagurskaya.service.RateNBService;
//import com.gmail.zagurskaya.service.UserService;
//import com.gmail.zagurskaya.service.UsersEntriesService;
//import com.gmail.zagurskaya.service.util.UserUtil;
//import com.gmail.zagurskaya.service.model.UserDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_CONTROLLER;
//import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_CONTROLLER_DUTIES;
//import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_CONTROLLER_ENTRIES;
//import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_CONTROLLER_RATECB;
//import static com.gmail.zagurskaya.web.constant.URLConstant.PATH_CONTROLLER_RATENB;
//import static com.gmail.zagurskaya.web.constant.URLConstant.PAYH_CONTROLLER_ALL_CURRENCIES;
//import static com.gmail.zagurskaya.web.constant.URLConstant.URL_CONTROLLER;
//import static com.gmail.zagurskaya.web.constant.URLConstant.URL_CONTROLLER_ALL_CURRENCIES;
//import static com.gmail.zagurskaya.web.constant.URLConstant.URL_CONTROLLER_ENTRIES;
//import static com.gmail.zagurskaya.web.constant.URLConstant.URL_CONTROLLER_RATECB;
//import static com.gmail.zagurskaya.web.constant.URLConstant.URL_CONTROLLER_RATENB;
//
//@Controller
//@RequestMapping(URL_CONTROLLER)
//public class ControllerController {
//
//    private final UserService userService;
//    private final CurrencyService currencyService;
//    private final RateNBService rateNBService;
//    private final RateCBService rateCBService;
//    private final DutiesService dutiesService;
//    private final UsersEntriesService usersEntriesService;
//    private final UserUtil userUtil;
//
//    @Autowired
//    public ControllerController(UserService userService, CurrencyService currencyService, RateNBService rateNBService, RateCBService rateCBService, DutiesService dutiesService, UsersEntriesService usersEntriesService, UserUtil userUtil) {
//
//        this.userService = userService;
//        this.currencyService = currencyService;
//        this.rateNBService = rateNBService;
//        this.rateCBService = rateCBService;
//        this.dutiesService = dutiesService;
//        this.usersEntriesService = usersEntriesService;
//        this.userUtil = userUtil;
//    }
//
//    @GetMapping
//    public String getControllerPage(Model model) {
//        UserDTO user = userUtil.getActualUser();
//        String FullName = user.getFirstName()+" "+user.getLastName()+" "+user.getPatronymic();
//        model.addAttribute("FullName", FullName);
//        return PATH_CONTROLLER;
//    }
//
//    @GetMapping(URL_CONTROLLER_ALL_CURRENCIES)
//    public String getAllCurrencyInControllerPage(Model model) {
//        List<CurrencyDTO> currencies = currencyService.getCurrencies();
//        model.addAttribute("currencies", currencies);
//        return PAYH_CONTROLLER_ALL_CURRENCIES;
//    }
//    @GetMapping(URL_CONTROLLER_RATENB)
//    public String getRateNBInControllerPage(Model model) {
//        List<RateNBDTO> ratesNB = rateNBService.getRatesNB();
//        model.addAttribute("ratesnb", ratesNB);
//        return PATH_CONTROLLER_RATENB;
//    }
//    @GetMapping(URL_CONTROLLER_RATECB)
//    public String getRateCBInControllerPage(Model model) {
//        List<RateCBDTO> ratesCB = rateCBService.getRatesCB();
//        model.addAttribute("ratescb", ratesCB);
//        return PATH_CONTROLLER_RATECB;
//    }
//
//    @GetMapping(URL_CONTROLLER_ENTRIES)
//    public String getAllDutiesTodayInControllerPage(Model model) {
//        LocalDate date = LocalDate.now();
//        List<DutiesDTO> dutiesToday = dutiesService.getDutiesToday(date);
//        model.addAttribute("duties", dutiesToday);
//        return PATH_CONTROLLER_DUTIES;
//    }
//    @PostMapping(URL_CONTROLLER_ENTRIES)
//    public String postSelectPaymentInCashPage(@ModelAttribute(value = "id") Long id,
//                                              Model model) {
//        LocalDate date = LocalDate.now();
//        List<UsersEntriesDTO> usersEntriesDTOS = usersEntriesService.getUserEntriesTodayByDutiesId(id);
//        model.addAttribute("entries", usersEntriesDTOS);
//        return PATH_CONTROLLER_ENTRIES;
//    }
//}
