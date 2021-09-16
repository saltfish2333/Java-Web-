package com.zzf.dao.impl;

import com.zzf.dao.OrderDao;
import com.zzf.pojo.Order;

/**
 * @author zzf
 * @create 2021-08-23 14:37
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
