package com.my.asset.service;

import com.my.asset.Bean.LoginBean;
import com.my.asset.Bean.RegisterBean;
import com.my.asset.Bean.Result;


public interface UserService {
    Result register(RegisterBean registerBean);
    Result login(LoginBean loginBean);
}
