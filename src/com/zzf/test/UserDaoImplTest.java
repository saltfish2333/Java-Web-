package com.zzf.test;

import com.zzf.dao.UserDao;
import com.zzf.dao.impl.UserDaoImpl;
import com.zzf.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-18 17:21
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("张"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void saveUser() {
        User user = new User(null, "admin", "123456", "admin@zzf.com");
        System.out.println( userDao.saveUser(user) );
    }
}