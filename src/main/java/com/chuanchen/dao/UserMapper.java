package com.chuanchen.dao;

import com.chuanchen.entity.User;
import com.chuanchen.entity.UserLevel;
import org.apache.ibatis.annotations.Param;


/**
 * Created by chuanchenwine on 2017/4/20.
 */
public interface UserMapper {
    int isUserExist(@Param("userName") String userName);

    int saveUser(User user);

    int deleteUserByAlumnusId(int id);

    User findUserByNameAndPassword(@Param("userName") String userName,@Param("password") String password);

    int getTotalCount();

    String getUsernameById(@Param("id") int id);

}
