package com.zzf.test;

import com.zzf.pojo.Cart;
import com.zzf.pojo.CartItem;
import com.zzf.service.OrderService;
import com.zzf.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-23 15:12
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"c#",1,new BigDecimal(500),new BigDecimal(500)));
        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(cart,1);

    }
}