package com.zzf.dao;

import com.zzf.pojo.User;

/**
 * @author zzf
 * @create 2021-08-18 17:02
 */
public interface UserDao {
    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username,String password);
    public int saveUser(User user);
}
