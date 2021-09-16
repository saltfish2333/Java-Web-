package com.zzf.test;

import com.zzf.dao.OrderDao;
import com.zzf.dao.impl.OrderDaoImpl;
import com.zzf.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-23 14:44
 */
public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
//        String sql="insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
        orderDao.saveOrder(new Order("13",new Date(),new BigDecimal(13.5),0,1));
        System.out.println(orderDao);
    }
}