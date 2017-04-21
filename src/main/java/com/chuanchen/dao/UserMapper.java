package com.chuanchen.dao;

import com.chuanchen.entity.User;
import org.apache.ibatis.annotations.Param;


/**
 * Created by chuanchenwine on 2017/4/20.
 */
public interface UserMapper {
    int isUserExist(@Param("userName") String userName);

    int saveUser(User user);

}
