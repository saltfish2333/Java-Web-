package com.zzf.test;

import com.zzf.pojo.User;
import com.zzf.service.UserService;
import com.zzf.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-18 19:46
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"段誉","77889","duanyu@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"段誉","77889",null)));
    }

    @Test
    public void isExists() {
        System.out.println(userService.isExists("段誉"));
    }
}