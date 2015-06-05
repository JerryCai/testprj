package com.github.testprj.dao;

import java.util.List;

public interface TestFooDao {

	List<String> listValuesBySql(String sql, String... values);
}