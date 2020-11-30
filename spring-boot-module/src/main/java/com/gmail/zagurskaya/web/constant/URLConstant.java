package com.gmail.zagurskaya.web.constant;

public class URLConstant {
    public static final String URL_CASH = "/cash";
    public static final String URL_ADMIN = "/admin";
    public static final String URL_PROFILE = "/profile";
    public static final String URL_CONTROLLER = "/controller";
    public static final String URL_403 = "/403";
    public static final String URL_LOGIN = "/login";
    public static final String URL_REST_API = "/api/**";
    public static final String URL_USERS = "/users";
    public static final String URL_QUOTES = "/quotes";

    public static final String URL_ADMINISTRATOR_NEW_USERS = "/new_user";
    public static final String URL_ADMINISTRATOR_NEW_USERS_POST = "/users/new";
    public static final String URL_ADMINISTRATOR_USERS_DELETE = "/users/delete";
    public static final String URL_ADMINISTRATOR_UPDATE_ROLE = "/users/update_role";
    public static final String URL_ADMINISTRATOR_UPDATE_PASSWORD = "/users/update_password";
    public static final String URL_ADMINISTRATOR_quotes = "/quotes";
    public static final String URL_ADMINISTRATOR_quotes_DELETE = "/quotes/delete";
    public static final String URL_ADMINISTRATOR_EXIT = "/exit";

    public static final String PATH_ADMINISTRATOR_USERS = "administrator/users";
    public static final String PATH_ADMINISTRATOR_ADMIN = "administrator/admin";
    public static final String PATH_ADMINISTRATOR_NEW_USERS = "administrator/new_user";
    public static final String PATH_ADMINISTRATOR_NEW_USERS_POST = "redirect:/admin/users";
    public static final String PATH_ADMINISTRATOR_quotes = "administrator/quotes";
    public static final String PATH_ADMINISTRATOR_quotes_REDIRECT = "redirect:/admin/quotes";

    public static final String PATH_QUOTES = "quotes";



    private URLConstant() {
    }
}
