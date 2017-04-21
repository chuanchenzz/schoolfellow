package com.chuanchen.typehandler;

import com.chuanchen.entity.Sex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexTypeHandler extends BaseTypeHandler<Sex> {
    private Class<Sex> sex;
    private Sex[] sexes;

    public SexTypeHandler(Class<Sex> sex) {
        if (sex == null) {
            throw new IllegalArgumentException("sex can't be null!");
        }
        this.sex = sex;
        this.sexes = sex.getEnumConstants();
        if (sexes == null) {
            throw new IllegalArgumentException("sexes can't be null");
        }
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        int sexCode = sex.getCode();
        preparedStatement.setInt(i, sexCode);
    }

    public Sex getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sexCode = resultSet.getInt(s);
        return Sex.codeToSex(sexCode);
    }

    public Sex getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sexCode = resultSet.getInt(i);
        return Sex.codeToSex(sexCode);
    }

    public Sex getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sexCode = callableStatement.getInt(i);
        return Sex.codeToSex(sexCode);
    }
}
