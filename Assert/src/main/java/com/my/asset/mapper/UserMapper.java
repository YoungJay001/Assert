package com.my.asset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.asset.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
