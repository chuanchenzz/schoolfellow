package com.chuanchen.typehandler;

import com.chuanchen.entity.CommonCode;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
public class CodeTypeHandler extends BaseTypeHandler<CommonCode> {
    private Class<CommonCode> commonCode;

    public CodeTypeHandler(Class<CommonCode> commonCode) {
        if (commonCode == null) {
            throw new IllegalArgumentException("commonCode can't be null!");
        }
        this.commonCode = commonCode;
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, CommonCode commonCode, JdbcType jdbcType) throws SQLException {
        int code = commonCode.getId();
        preparedStatement.setInt(i,code);
    }

    public CommonCode getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        CommonCode commonCode = new CommonCode();
        commonCode.setId(code);
        return commonCode;
    }

    public CommonCode getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        CommonCode commonCode = new CommonCode();
        commonCode.setId(code);
        return commonCode;
    }

    public CommonCode getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        CommonCode commonCode = new CommonCode();
        commonCode.setId(code);
        return commonCode;
    }
}
