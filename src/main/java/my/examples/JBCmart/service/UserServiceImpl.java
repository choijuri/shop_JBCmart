package my.examples.JBCmart.service;

import my.examples.JBCmart.dao.UserDao;
import my.examples.JBCmart.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDao.selectAll();
    }
}
