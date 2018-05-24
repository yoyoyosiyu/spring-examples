package com.kgl1688.service;

import com.kgl1688.dao.UserDAO;
import com.kgl1688.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Resource
    private UserDAO userDao;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User createUser(User u) {
        return userDao.createUser(u);
    }

    public User createUser(String first_name, String last_name, int age) {
        User u = new User();
        u.setFirst_name(first_name);
        u.setLast_name(last_name);
        u.setAge(age);

        return userDao.createUser(u);
    }

    public void deleteUser(int user_id) {
        userDao.delUser(user_id);
    }


    public void updateUser(User u) {
        userDao.updateUser(u);
    }





}
