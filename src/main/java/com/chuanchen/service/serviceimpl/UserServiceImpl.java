package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.AlumnusMapper;
import com.chuanchen.dao.UserMapper;
import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.User;
import com.chuanchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/18.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    AlumnusMapper alumnusMapper;
    public boolean isAlumnusExist(String name, String studentNumber, Date startAge) {
        int result = alumnusMapper.isAlumnusExist(name,studentNumber,startAge);
        if(result > 0){
            return true;
        }
        return false;
    }

    public boolean isUserExist(String userName) {
        int result = userMapper.isUserExist(userName);
        if(result > 0){
            return true;
        }
        return false;
    }
    @Transactional
    public int saveUserAndAlumnus(User user, Alumnus alumnus) {
        int insertId = alumnusMapper.saveAlumnus(alumnus);
        if(insertId > 0){
            user.setAlumnusId(insertId);
            int result = userMapper.saveUser(user);
            return result > 0 ? result : 0;
        }
        return 0;
    }

    public Alumnus getAlumnusById(int id) {
        return alumnusMapper.getAlumnusById(id);
    }
    @Transactional
    public int deleteAlumnusAndUserById(int id) {
        int resultId = alumnusMapper.deleteAlumusById(id);
        if(resultId > 0){
            return userMapper.deleteUserByAlumnusId(id);
        }else {
            return 0;
        }
    }
}
