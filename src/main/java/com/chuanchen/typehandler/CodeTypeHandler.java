package com.chuanchen.typehandler;

import com.chuanchen.dao.CodeMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
public class CodeTypeHandler extends BaseTypeHandler<String> {
    private Class<String> str;
    private String[] strs;
    @Autowired
    CodeMapper codeMapper;

    public CodeTypeHandler(Class<String> str) {
        if (str == null) {
            throw new IllegalArgumentException("str can't be null!");
        }
        this.str = str;
        this.strs = str.getEnumConstants();
        if (strs == null) {
            throw new IllegalArgumentException("strs can't be null!");
        }
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        int code = codeMapper.getIdByName(s);
        preparedStatement.setInt(i, code);
    }

    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        return codeMapper.getNameById(code);
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        return codeMapper.getNameById(code);
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        return codeMapper.getNameById(code);
    }
}
