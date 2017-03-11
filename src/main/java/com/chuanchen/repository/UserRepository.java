package com.chuanchen.repository;

import com.chuanchen.entity.User;

/**
 * Created by chuanchen-pc on 2017/3/11.
 */
public interface UserRepository{
    long findUserByuserNameAndPassword(String userName,String password);

    User findUserById(long id);
}
