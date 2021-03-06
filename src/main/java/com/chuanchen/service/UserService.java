package com.chuanchen.service;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/18.
 */
public interface UserService {
    boolean isAlumnusExist(String name, String studentNumber);

    boolean isUserExist(String userName);

    int saveUserAndAlumnus(User user, Alumnus alumnus);

    Alumnus getAlumnusById(int id);

    int deleteAlumnusAndUserById(int id);

    User findUserByNameAndPassword(String userName,String password);

    int getTotalPage();

    List<Alumnus> findAlumnuses(int page,int limit);

    String getAlumnusNameById(int id);

    String getUsernameById(int id);

    int getCountByCity(int cityCode);

    List<Alumnus> getAlumnusesByCity(int page,int limit,int cityCode);
}
