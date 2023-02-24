package com.attrabit.ecom.constant;

public class URLSuppliers {
    public static final String BASE_URL = "/api/v1";

    public static final String HOME_URL = BASE_URL +"/home";
    public static final String USERS_URL = BASE_URL +"/users";

    public static final String HOME_PAGE_URLS = HOME_URL +"/homePage";
    public static final String HOME_PAGE_ALL_USERS_URLS = HOME_URL +"/all";
    public static final String USER_SIGNUP = USERS_URL +"/register";
    public static final String USER_LOGIN = USERS_URL +"/login";
    public static final String USER_LOGOUT = USERS_URL +"/logout";

    public static final String AUTH_CONTROLLER_BASE = BASE_URL +"/auth";
    public static final String USER_DASHBOARD = AUTH_CONTROLLER_BASE+"/dashboard";
}
