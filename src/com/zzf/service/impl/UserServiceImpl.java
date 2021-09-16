package com.zzf.service.impl;

import com.zzf.dao.UserDao;
import com.zzf.dao.impl.UserDaoImpl;
import com.zzf.pojo.User;
import com.zzf.service.UserService;

/**
 * @author zzf
 * @create 2021-08-18 19:41
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean isExists(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
