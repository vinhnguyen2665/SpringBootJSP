package com.vinhnq.controller;

import com.google.gson.Gson;
import com.vinhnq.common.CommonConst;
import com.vinhnq.common.URLConst;
import com.vinhnq.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import com.vinhnq.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public abstract class BaseController {
    @Autowired
    UserService userService;

    static Gson gson;

    private static final Logger logger = LogManager.getLogger(BaseController.class);

    protected User getUser() {
        try {
            Authentication authen = SecurityContextHolder.getContext().getAuthentication();
            if (authen != null) {
                return userService.getUserInfoByName(authen.getName());
            } else {
                return new User();
            }
        } catch (Exception ex) {
            logger.error(CommonConst.COMMON_MESSAGE.USER_NOT_LOGIN, ex);
            return new User();
            //throw new RuntimeException(CommonConst.COMMON_MESSAGE.USER_NOT_LOGIN);
        }
    }
    public Gson getGSon() {
        if(null ==  this.gson){
            this.gson = new Gson();
        }
        return  this.gson;
    }
    @ModelAttribute("userLogin")
    public User userLogin() {
        return this.getUser();
    }


    @ModelAttribute("currentPath")
    protected String currentPath(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath(), "").replaceAll(URLConst.lang_support_regex, "");
    }
}
