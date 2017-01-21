package com.dex.data.dao;

import com.dex.data.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dexter on 09.01.17.
 */
public class UserDao {

    private DataSource dataSource;

    public List<User> selectAllUsers(){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM users";
        return template.query(sql, UserMapper.instance);
    }

    public List<User> selectAllUsers(String login, String pass){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM users WHERE login = :login and pass = :pass";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("login", login);
        parameters.addValue("pass", pass);

        return template.query(sql, UserMapper.instance, parameters);
    }


    private static class UserMapper implements RowMapper<User> {

        static final UserMapper instance = new UserMapper();

        public User mapRow(ResultSet result, int i) throws SQLException {
            User user = new User();
            user.login = result.getString("login");
            user.id = result.getInt("id");
            user.pass = result.getString("pass");

            return user;
        }

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
