package com.qzp.app.Dao;

import com.qzp.app.entity.User;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface UserDao {

    void addUser(User user);

    User findUser(String loginname);
}
