package com.qzp.app.User.action;


import com.qzp.app.User.service.UserService;
import com.qzp.app.common.PageBean;
import com.qzp.app.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/27.
 */
@Controller
@Scope("prototype")
@RequestMapping("/userAction")
public class UserAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService service;
    private Map<String,String> errors = new HashMap<String,String>();


    @RequestMapping("/login")
    public String Login(@ModelAttribute User user,HttpServletRequest request,Model model) {

        try {
            boolean flag = service.login(user);
            if (flag) {
                String str = new String("用户名与密码不匹配");
                errors.put("loginname", str);
                model.addAttribute("errors", errors);
                return "forward:/jsps/user/login.jsp";
            }
            request.getSession().setAttribute("user", user);
            return "forward:/index.jsp";
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e.getMessage());
        }
    }


    @RequestMapping("/register")
 public String RegisterAction(@ModelAttribute User user,Model model){
        try{
            boolean flag = service.findUser(user.getLoginname());
            if (flag){
                String str = new String("用户名已存在");
                errors.put("loginname",str);
                model.addAttribute("errors", errors);

                return "forward:/jsps/user/regist.jsp";
            }
                 user.setUid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                   service.addUser(user);

             return "forward:/jsps/msg.jsp";

        }catch (Exception e){
            logger.error(e.getMessage(),e);
          throw new RuntimeException(e.getMessage());
        }
 }



}
