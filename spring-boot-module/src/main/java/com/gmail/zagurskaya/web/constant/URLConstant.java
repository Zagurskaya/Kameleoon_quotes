package com.gmail.zagurskaya.web.constant;

public class URLConstant {

    public static final String URL_403 = "/403";
    public static final String URL_LOGIN = "/login";
    public static final String URL_REST_API = "/api/**";

    public static final String URL_PROFILE = "/profile/quotes";
    public static final String URL_PROFILE_DELETE = "/delete";
    public static final String URL_PROFILE_UPDATE = "/update";
    public static final String URL_PROFILE_UPDATE_ID = "/{id}";
    public static final String URL_PROFILE_ADD = "/add";

    public static final String URL_QUOTES = "/quotes";


    public static final String PATH_PROFILE = "/user/profile";
    public static final String PATH_QUOTE = "/user/quote";
    public static final String PATH_NEW_QUOTE = "/user/new_quote";
    public static final String PATH_PROFILE_POST = "redirect:/profile/quotes";
//    public static final String PATH_PROFILE_POST_NEW_QUOTE = "redirect:/profile/quotes/add";

    public static final String PATH_QUOTES = "/guest/quotes";


    private URLConstant() {
    }
}
