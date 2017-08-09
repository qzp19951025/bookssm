package com.qzp.app.User.service;

import com.qzp.app.entity.User;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface UserService {
    void addUser(User user);
    boolean findUser(String loginname);

    boolean login(User user);
}
