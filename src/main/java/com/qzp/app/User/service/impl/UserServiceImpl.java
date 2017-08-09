package com.qzp.app.User.service.impl;

import com.qzp.app.Dao.UserDao;
import com.qzp.app.User.service.UserService;
import com.qzp.app.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao dao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void addUser(User user) {
        try{
            dao.addUser(user);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public boolean findUser(String loginname) {
            try{
             User user = dao.findUser(loginname);
                if(user != null){
                    return true;
                }
                return false;
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e.getMessage());
            }

        }

    @Override
    public boolean login(User user) {
       User user2 = dao.login(user);
        if(user2 == null){
            return true;
        }
        return false;
    }
}
