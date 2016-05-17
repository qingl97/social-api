package com.amundi.social.repo.dao.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

public class JodaDateTimeTypeHandler extends BaseTypeHandler<DateTime> {

	@Override
	public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return toDateTime(rs.getTimestamp(columnName));
	}

	@Override
	public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return toDateTime(rs.getTimestamp(columnIndex));
	}

	@Override
	public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return toDateTime(cs.getTimestamp(columnIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int columnIndex, DateTime param, JdbcType jdbcType) throws SQLException {
		ps.setTimestamp(columnIndex, new Timestamp(param.getMillis()));
	}
	
	private DateTime toDateTime(Timestamp timestamp) {
        return timestamp == null ? null : new DateTime(timestamp.getTime());
    }

}
