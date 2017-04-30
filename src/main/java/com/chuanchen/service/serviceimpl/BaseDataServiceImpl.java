package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.CommonCodeMapper;
import com.chuanchen.entity.CodeType;
import com.chuanchen.entity.CommonCode;
import com.chuanchen.service.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public CommonCode getCommonCodeFromCacheById(int type, int id) {
        Map<String,List<CommonCode>> cacheMap = findCodes();
        CommonCode result = null;
        List<CommonCode> codes = cacheMap.get(String.valueOf(type));
        for (CommonCode commonCode : codes){
            if(commonCode.getId() == id){
                result = commonCode;
                break;
            }
        }
        if(result == null){
            result = getCommonCodeById(type,id);
        }
        return result;
    }

    public CommonCode getCommonCodeFromCacheByName(int type, String name) {
        Map<String,List<CommonCode>> cacheCode = findCodes();
        CommonCode result = null;
        List<CommonCode> codes = cacheCode.get(String.valueOf(type));
        for (CommonCode commonCode : codes){
            if(commonCode.getName().equals(name)){
                result = commonCode;
            }
        }
        if(result == null){
            result = getCommonCodeByName(type,name);
        }
        return result;
    }

    public CommonCode getCommonCodeById(int type, int id) {
        return commonCodeMapper.getCommonCodeById(type,id);
    }

    public CommonCode getCommonCodeByName(int type, String name) {
        return commonCodeMapper.getCommonCodeByName(type,name);
    }

    @Cacheable("cachecode")
    public Map<String,List<CommonCode>> findCodes(){
        Map<String,List<CommonCode>> cacheMap = new HashMap<String, List<CommonCode>>();
        List<CommonCode> addressCode = commonCodeMapper.getCommonCodesByType(CodeType.CITY.getCode());
        cacheMap.put(String.valueOf(CodeType.CITY.getCode()),addressCode);
        List<CommonCode> nationCode = commonCodeMapper.getCommonCodesByType(CodeType.NATION.getCode());
        cacheMap.put(String.valueOf(CodeType.NATION.getCode()),nationCode);
        List<CommonCode> identityCode = commonCodeMapper.getCommonCodesByType(CodeType.IDENTITY.getCode());
        cacheMap.put(String.valueOf(CodeType.IDENTITY.getCode()),identityCode);
        List<CommonCode> natureCode = commonCodeMapper.getCommonCodesByType(CodeType.COMPANY_NATURE.getCode());
        cacheMap.put(String.valueOf(CodeType.COMPANY_NATURE.getCode()),natureCode);
        List<CommonCode> industryCode = commonCodeMapper.getCommonCodesByType(CodeType.INDUSTRY.getCode());
        cacheMap.put(String.valueOf(CodeType.INDUSTRY.getCode()),industryCode);
        List<CommonCode> educationCode = commonCodeMapper.getCommonCodesByType(CodeType.EDUCATION.getCode());
        cacheMap.put(String.valueOf(CodeType.EDUCATION.getCode()),educationCode);
        return cacheMap;
    }
}
