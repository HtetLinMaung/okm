package com.nirvasoft.web.utils;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class QueryUtil {
    protected long getNextId(String tableName, String fieldName, JdbcTemplate jdbcTemplate) {
        final String sql = "SELECT MAX(" + fieldName + ") AS id FROM " + tableName;
        long id = 9990000000L;

        List<Long> arr = jdbcTemplate.query(sql, (rs, i) -> {
            return rs.getLong("id") + 1;
        });
        id = arr.get(0);
        return id;
    }
}
