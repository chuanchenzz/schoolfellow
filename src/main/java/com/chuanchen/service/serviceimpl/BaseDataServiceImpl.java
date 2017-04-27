package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.CommonCodeMapper;
import com.chuanchen.entity.CodeType;
import com.chuanchen.entity.CommonCode;
import com.chuanchen.service.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/26.
 */
@Service
public class BaseDataServiceImpl implements BaseDataService{
    @Autowired
    CommonCodeMapper commonCodeMapper;
    public List<CommonCode> getCommonCodesByType(CodeType type) {
        return commonCodeMapper.getCommonCodesByType(type.getCode());
    }
}
