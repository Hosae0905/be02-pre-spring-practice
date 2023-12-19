package com.example.springboot;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean update(String id, String pw, String newPw) {

        String sql = "UPDATE SET user ";
        if (jdbcTemplate.update(sql) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
