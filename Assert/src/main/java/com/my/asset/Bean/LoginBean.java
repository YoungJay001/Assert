package com.my.asset.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录封装bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBean {
    private String name;
    private String password;
}
