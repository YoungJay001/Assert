package com.my.asset.controller;


import com.my.asset.Bean.LoginBean;
import com.my.asset.Bean.RegisterBean;

import com.my.asset.Bean.Result;
import com.my.asset.service.UserService;
import com.my.asset.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param registerBean 注册信息
     * @return Result
     */
    @PostMapping("/register")
    public Result register(@RequestBody RegisterBean registerBean) {
        return userService.register(registerBean);
    }

    /**
     * 登录接口
     *
     * @param loginBean 登录信息
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginBean loginBean) {
        return userService.login(loginBean);
    }

    /**
     * 查询用户地址
     *
     * @param request 请求
     * @return 用户地址
     */
    public String getAddress(HttpServletRequest request) {
        return TokenUtil.getAddress(request.getHeader("Authorization"));
    }

}
