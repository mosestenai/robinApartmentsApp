package com.example.robin.api;

import com.example.robin.User;

public interface APIListener {
    void onLogin(User user);
    void onRegister(User user);
    void landlordview(User user);
    void onhostels(User user);
    void onaddhostel(User user);
}
