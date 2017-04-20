package com.chuanchen.service.serviceimpl;

import com.chuanchen.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/18.
 */
@Service
public class UserServiceImpl implements UserService{

    public boolean isUserExist(String name, String studentNumber, Date startAge) {
        return false;
    }
}
