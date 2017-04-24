package com.chuanchen.typehandler;

import com.chuanchen.entity.NoticeType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public class NoticeTypeHandler extends BaseTypeHandler<NoticeType> {
    private Class<NoticeType> noticeType;

    private NoticeType[] noticeTypes;

    public NoticeTypeHandler(Class<NoticeType> noticeType) {
        if (noticeType == null) {
            throw new IllegalArgumentException("noticeType can't be null!");
        }
        this.noticeType = noticeType;
        noticeTypes = noticeType.getEnumConstants();
        if (noticeTypes == null) {
            throw new IllegalArgumentException("noticeTypes can't be null!");
        }
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, NoticeType noticeType, JdbcType jdbcType) throws SQLException {
        int type = noticeType.getType();
        preparedStatement.setInt(i, type);
    }

    public NoticeType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int type = resultSet.getInt(s);
        return NoticeType.codeToType(type);
    }

    public NoticeType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int type = resultSet.getInt(i);
        return NoticeType.codeToType(type);
    }

    public NoticeType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int type = callableStatement.getInt(i);
        return NoticeType.codeToType(type);
    }
}
