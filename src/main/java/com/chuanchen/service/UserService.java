package com.chuanchen.service;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/18.
 */
public interface UserService {
    boolean isUserExist(String name, String studentNumber, Date startAge);
}
