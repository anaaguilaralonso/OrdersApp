package com.einao.ordersapp.domain.auth;

public interface Authenticator {

    void registerAuthenticator();

    void unregisterAuthenticator();

    void authenticate(String email, String password);
}
