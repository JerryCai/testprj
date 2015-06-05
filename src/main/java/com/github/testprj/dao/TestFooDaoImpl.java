package com.github.testprj.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestException;

import com.googlecode.openbox.db.C3p0DbPoolImpl;
import com.googlecode.openbox.db.DbPool;

public class TestFooDaoImpl implements TestFooDao {
	private static final Logger logger = LogManager.getLogger();

	private DbPool dbClient;

	private TestFooDaoImpl(String webdbPropertiesPath) {
		dbClient = C3p0DbPoolImpl.newInstance(webdbPropertiesPath);
	}

	public static TestFooDaoImpl newInstance(String webdbPropertiesPath) {
		return new TestFooDaoImpl(webdbPropertiesPath);
	}

	String SQL_DEMO = "select xx , yy from tableA where id = ?";

	public List<String> listValuesBySql(String sql, String... values) {
		Connection dbconn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<String> results = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		try {
			dbconn = dbClient.getConnection();
			cs = dbconn.prepareCall(sql);
			String valuesStr = "";
			for (int i = 1; i <= values.length; i++) {
				String value = values[i - 1];
				cs.setString(i, value);
				valuesStr = value + ",";
			}
			rs = cs.executeQuery();
			ResultSetMetaData rsmd = cs.getMetaData();
			String columInfo = "| ";
			int columnCount = rsmd.getColumnCount();
			for (int column = 1; column <= columnCount; column++) {
				columInfo = columInfo + rsmd.getColumnName(column) + " |";
			}
			sb.append("\n" + sql + "  " + valuesStr).append("\n");
			sb.append(columInfo).append("\n");
			while (rs.next()) {
				String result = "| ";
				for (int column = 1; column <= columnCount; column++) {
					String value = rs.getString(column);
					result = result + value + " |";
					results.add(value);
				}
				sb.append(result).append("\n");
			}
			if (logger.isInfoEnabled()) {
				logger.info(sb.toString());
			}
		} catch (SQLException e) {
			logger.error("execute SQL [" + sql + "] error !", e);
			throw new TestException(e);
		} finally {
			dbClient.close(dbconn, cs, rs);
		}

		return results;
	}

}
