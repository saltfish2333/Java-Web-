package com.zzf.dao.impl;

import com.zzf.dao.OrderItemDao;
import com.zzf.pojo.OrderItem;

/**
 * @author zzf
 * @create 2021-08-23 14:41
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getCount(),orderItem.getOrderId());

    }
}
