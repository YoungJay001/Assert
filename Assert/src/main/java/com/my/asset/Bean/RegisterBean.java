package com.my.asset.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注册封装bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBean {
    private String name;
    private String password;
    private String email;
    private String role;
    private Integer age;
    private String address;
}
