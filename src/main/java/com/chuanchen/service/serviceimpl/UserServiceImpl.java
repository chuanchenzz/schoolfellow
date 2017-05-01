package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.AlumnusMapper;
import com.chuanchen.dao.UserMapper;
import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.CodeType;
import com.chuanchen.entity.User;
import com.chuanchen.service.BaseDataService;
import com.chuanchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/18.
 */
@Service
public class UserServiceImpl implements UserService{
    private final int PAGE_COUNT = 15;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AlumnusMapper alumnusMapper;
    @Autowired
    BaseDataService baseDataService;
    public boolean isAlumnusExist(String name, String studentNumber) {
        int result = alumnusMapper.isAlumnusExist(name,studentNumber);
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
        Alumnus alumnus = alumnusMapper.getAlumnusById(id);
        alumnus.setAddress(baseDataService.getCommonCodeFromCacheById(CodeType.CITY.getCode(),alumnus.getAddress().getId()));
        alumnus.setBirthPlace(baseDataService.getCommonCodeFromCacheById(CodeType.CITY.getCode(),alumnus.getBirthPlace().getId()));
        alumnus.setEducation(baseDataService.getCommonCodeFromCacheById(CodeType.EDUCATION.getCode(),alumnus.getEducation().getId()));
        alumnus.setIdentity(baseDataService.getCommonCodeFromCacheById(CodeType.IDENTITY.getCode(),alumnus.getIdentity().getId()));
        alumnus.setIndustry(baseDataService.getCommonCodeFromCacheById(CodeType.INDUSTRY.getCode(),alumnus.getIndustry().getId()));
        alumnus.setNation(baseDataService.getCommonCodeFromCacheById(CodeType.NATION.getCode(),alumnus.getNation().getId()));
        alumnus.setOrganizationNature(baseDataService.getCommonCodeFromCacheById(CodeType.COMPANY_NATURE.getCode(),alumnus.getOrganizationNature().getId()));
        alumnus.setWorkAddress(baseDataService.getCommonCodeFromCacheById(CodeType.CITY.getCode(),alumnus.getWorkAddress().getId()));
        return alumnus;
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

    public User findUserByNameAndPassword(String userName, String password) {
        return userMapper.findUserByNameAndPassword(userName,password);
    }

    public int getTotalPage() {
        int totalCount = alumnusMapper.getAlumnusCount();
        return totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
    }

    public List<Alumnus> findAlumnuses(int page, int limit) {
        int begin = (page - 1) * PAGE_COUNT;
        List<Alumnus> alumnusList = alumnusMapper.findAlumnuses(begin,limit);
        for (Alumnus alumnus : alumnusList){
            alumnus.setAddress(baseDataService.getCommonCodeFromCacheById(CodeType.CITY.getCode(),alumnus.getAddress().getId()));
            alumnus.setBirthPlace(baseDataService.getCommonCodeFromCacheById(CodeType.CITY.getCode(),alumnus.getBirthPlace().getId()));
            alumnus.setEducation(baseDataService.getCommonCodeFromCacheById(CodeType.EDUCATION.getCode(),alumnus.getEducation().getId()));
            alumnus.setIdentity(baseDataService.getCommonCodeFromCacheById(CodeType.IDENTITY.getCode(),alumnus.getIdentity().getId()));
            alumnus.setIndustry(baseDataService.getCommonCodeFromCacheById(CodeType.INDUSTRY.getCode(),alumnus.getIndustry().getId()));
            alumnus.setNation(baseDataService.getCommonCodeFromCacheById(CodeType.NATION.getCode(),alumnus.getNation().getId()));
            alumnus.setOrganizationNature(baseDataService.getCommonCodeFromCacheById(CodeType.COMPANY_NATURE.getCode(),alumnus.getOrganizationNature().getId()));
            alumnus.setWorkAddress(baseDataService.getCommonCodeFromCacheById(CodeType.CITY.getCode(),alumnus.getWorkAddress().getId()));
        }
        return alumnusList;
    }

    public String getAlumnusNameById(int id) {
        return alumnusMapper.getAlumnusNameById(id);
    }
}
