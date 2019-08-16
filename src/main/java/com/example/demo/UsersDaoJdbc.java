package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

class UsersDaoJdbc extends JdbcDaoSupport {

    public List<User> getUsers() {
        List<User> users = getJdbcTemplate().query("select id, name from users", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User c = new User();
                c.setId(rs.getLong(1));
                c.setName(rs.getString(2));
                return c;
            }
        });
        return users;
    }
}