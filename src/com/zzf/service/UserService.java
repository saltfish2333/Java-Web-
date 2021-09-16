package com.zzf.service;

import com.zzf.pojo.User;

/**
 * @author zzf
 * @create 2021-08-18 19:39
 */
public interface UserService {
    public void registUser(User user);
    public User login(User user);
    public boolean isExists(String username);
}
