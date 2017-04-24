package com.chuanchen.typehandler;

import com.chuanchen.util.CommonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;
import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
@MappedJdbcTypes(JdbcType.DATE)
public class DateTypeHandler extends BaseTypeHandler<String> {
    private Class<String> str;

    public DateTypeHandler(Class<String> str) {
        if (str == null) {
            throw new IllegalArgumentException("str can't be null!");
        }
        this.str = str;
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        Date date = CommonUtil.strToDate(s);
        preparedStatement.setTimestamp(i, new Timestamp(date.getTime()));
    }

    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Date date = new Date(resultSet.getTimestamp(s).getTime());
        return CommonUtil.dateToStr(date);
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Date date = new Date(resultSet.getTimestamp(i).getTime());
        return CommonUtil.dateToStr(date);
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = new Date(callableStatement.getTimestamp(i).getTime());
        return CommonUtil.dateToStr(date);
    }
}
