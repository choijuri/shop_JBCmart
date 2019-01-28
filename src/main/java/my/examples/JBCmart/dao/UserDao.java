package my.examples.JBCmart.dao;

import my.examples.JBCmart.dto.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();
}
