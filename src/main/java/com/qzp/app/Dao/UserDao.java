package com.qzp.app.Dao;

import com.qzp.app.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface UserDao {

    void addUser(User user);

    User findUser(String loginname);

    User login(@Param("user")User user);

}
