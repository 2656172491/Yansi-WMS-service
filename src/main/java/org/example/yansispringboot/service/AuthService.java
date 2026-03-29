package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.User;

public interface AuthService {
    String login(String username, String password);

    User getUserInfo(String username);
}
