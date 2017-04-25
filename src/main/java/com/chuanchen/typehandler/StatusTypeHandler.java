package com.chuanchen.typehandler;

import com.chuanchen.entity.Status;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/4/25.
 */
public class StatusTypeHandler extends BaseTypeHandler<Status> {
    private Class<Status> status;
    private Status[] statuses;

    public StatusTypeHandler(Class<Status> status) {
        if (status == null) {
            throw new IllegalArgumentException("status can't be null!");
        }
        this.status = status;
        this.statuses = status.getEnumConstants();
        if (statuses == null) {
            throw new IllegalArgumentException("statuses can't be null!");
        }
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Status status, JdbcType jdbcType) throws SQLException {
        int statusCode = status.getStatusCode();
        preparedStatement.setInt(i, statusCode);
    }

    public Status getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int statusCode = resultSet.getInt(s);
        return Status.codeToStatus(statusCode);
    }

    public Status getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int statusCode = resultSet.getInt(i);
        return Status.codeToStatus(statusCode);
    }

    public Status getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int statusCode = callableStatement.getInt(i);
        return Status.codeToStatus(statusCode);
    }
}
