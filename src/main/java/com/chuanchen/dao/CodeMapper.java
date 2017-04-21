package com.chuanchen.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
public interface CodeMapper {
    int insertCodeModel(@Param("name") String name,@Param("codeType") int codeType);

    int getIdByName(@Param("name") String name);

    String getNameById(@Param("id") int id);

    List<String> getNameListByCode(@Param("codeType") int codeType);
}
