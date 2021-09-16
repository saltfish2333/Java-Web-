package com.zzf.test;

import com.zzf.dao.OrderItemDao;
import com.zzf.dao.impl.OrderItemDaoImpl;
import com.zzf.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-23 14:50
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(1,"hah",new BigDecimal(19.9),new BigDecimal(19.9),1,"13"));

    }
}