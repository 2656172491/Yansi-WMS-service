package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.User;

public interface AuthService {
    boolean login(String username, String password);

    User getUserInfo(String username);
}
