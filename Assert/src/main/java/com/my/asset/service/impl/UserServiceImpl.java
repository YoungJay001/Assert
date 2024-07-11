package com.my.asset.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.asset.Bean.LoginBean;
import com.my.asset.Bean.RegisterBean;
import com.my.asset.Bean.Result;
import com.my.asset.constant.MessageConstant;
import com.my.asset.mapper.UserMapper;
import com.my.asset.pojo.UserEntity;
import com.my.asset.service.UserService;
import com.my.asset.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Slf4j
@Component
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 注册接口
     *
     * @param registerBean 注册Bean
     * @return Result
     */
    public Result register(RegisterBean registerBean) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(registerBean, userEntity);
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userEntity.getName());
        if (userMapper.selectOne(queryWrapper) != null) {
            return Result.error(400, MessageConstant.ALREADY_EXIST);
        }

        userMapper.insert(userEntity);
        return Result.success();

    }

    /**
     * 登录接口
     *
     * @param loginBean 登录信息
     * @return Result
     */
    public Result login(LoginBean loginBean) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", loginBean.getName());
        queryWrapper.eq("password", loginBean.getPassword());
        UserEntity userEntity = userMapper.selectOne(queryWrapper);
        if (userEntity != null) {
            String token = TokenUtil.sign(userEntity.getName(), userEntity.getAddress(), String.valueOf(System.currentTimeMillis()));
            log.info(token);
            return Result.success(token);
        }
        return Result.error(402, MessageConstant.PASSWORD_ERROR);
    }


}
