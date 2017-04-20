package com.chuanchen.service;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.User;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/18.
 */
public interface UserService {
    boolean isAlumnusExist(String name, String studentNumber, Date startAge);

    boolean isUserExist(String userName);

    int saveUserAndAlumnus(User user, Alumnus alumnus);
}
