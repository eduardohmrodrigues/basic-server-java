package com.ehmr.webapp.auth;

public class UserAuthenticationService {

    public boolean isUserValid(String username, String password) {

        return username.equalsIgnoreCase("edrode") && password.equals("galactic");
    }
}
