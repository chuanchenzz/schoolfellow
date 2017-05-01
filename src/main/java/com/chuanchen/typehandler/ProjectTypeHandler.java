package com.chuanchen.typehandler;

import com.chuanchen.entity.ProjectType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
public class ProjectTypeHandler extends BaseTypeHandler<ProjectType> {
    private Class<ProjectType> projectType;
    private ProjectType[] projectTypes;

    public ProjectTypeHandler(Class<ProjectType> projectType) {
        if (projectType == null) {
            throw new IllegalArgumentException("projectType can't be null!");
        }
        this.projectType = projectType;
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, ProjectType projectType, JdbcType jdbcType) throws SQLException {
        int code = projectType.getCode();
        preparedStatement.setInt(i, code);
    }

    public ProjectType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        return ProjectType.codeToProjectType(code);
    }

    public ProjectType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        return ProjectType.codeToProjectType(code);
    }

    public ProjectType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        return ProjectType.codeToProjectType(code);
    }
}
