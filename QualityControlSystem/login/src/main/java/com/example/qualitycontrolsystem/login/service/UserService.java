package com.example.qualitycontrolsystem.login.service;

import com.example.qualitycontrolsystem.login.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(String username, String password) {
        int count = userDao.getCountByUsernameAndPassword(username, password);
        return count > 0;
    }
}
