package com.zzf.service.impl;

import com.zzf.dao.BookDao;
import com.zzf.dao.OrderDao;
import com.zzf.dao.OrderItemDao;
import com.zzf.dao.impl.BookDaoImpl;
import com.zzf.dao.impl.OrderDaoImpl;
import com.zzf.dao.impl.OrderItemDaoImpl;
import com.zzf.pojo.*;
import com.zzf.service.BookService;
import com.zzf.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author zzf
 * @create 2021-08-23 14:57
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
//        int i = 12/0;
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getPrice(),cartItem.getTotalPrice(),cartItem.getCount(),orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
