package com.chuanchen.typehandler;

import com.chuanchen.entity.UserLevel;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public class UserLevelHandler extends BaseTypeHandler<UserLevel> {
    private Class<UserLevel> userLevel;

    private UserLevel[] userLevels;

    public UserLevelHandler(Class<UserLevel> userLevel) {
        if (userLevel == null) {
            throw new IllegalArgumentException("userLevel can't be null!");
        }
        this.userLevel = userLevel;
        userLevels = userLevel.getEnumConstants();
        if (userLevels == null) {
            throw new IllegalArgumentException("userLevels can't be null!");
        }
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserLevel level, JdbcType jdbcType) throws SQLException {
        int type = level.getLevel();
        preparedStatement.setInt(i, type);
    }

    public UserLevel getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int type = resultSet.getInt(s);
        return UserLevel.levelToUserLevel(type);
    }

    public UserLevel getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int type = resultSet.getInt(i);
        return UserLevel.levelToUserLevel(type);
    }

    public UserLevel getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int type = callableStatement.getInt(i);
        return UserLevel.levelToUserLevel(type);
    }
}
