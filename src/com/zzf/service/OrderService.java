package com.zzf.service;

import com.zzf.pojo.Cart;

/**
 * @author zzf
 * @create 2021-08-23 14:56
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
