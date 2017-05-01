package com.chuanchen.typehandler;

import com.chuanchen.entity.DonationType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
public class DonationTypeHandler extends BaseTypeHandler<DonationType> {
    private Class<DonationType> donationType;
    private DonationType[] donationTypes;

    public DonationTypeHandler(Class<DonationType> donationType) {
        if (donationType == null) {
            throw new IllegalArgumentException("donationType can't be null!");
        }
        this.donationType = donationType;
        donationTypes = this.donationType.getEnumConstants();
        if (donationTypes == null) {
            throw new IllegalArgumentException("donationTypes can't be null!");
        }
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DonationType donationType, JdbcType jdbcType) throws SQLException {
        int code = donationType.getCode();
        preparedStatement.setInt(i, code);
    }

    public DonationType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        return DonationType.codeToType(code);
    }

    public DonationType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        return DonationType.codeToType(code);
    }

    public DonationType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        return DonationType.codeToType(code);
    }
}
