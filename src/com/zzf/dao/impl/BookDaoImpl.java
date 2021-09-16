package com.zzf.dao.impl;

import com.zzf.dao.BookDao;
import com.zzf.pojo.Book;

import java.util.List;

/**
 * @author zzf
 * @create 2021-08-21 13:05
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int updateBook(Book book) {
//        String sql="update t_book set( `name` , `author` , `price` , `sales` , `stock` , `img_path`)=(?,?,?,?,?,?) where id =?";
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());

    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book( `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number num = (Number) queryForSingleValue(sql);
        return num.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        List<Book> books = queryForList(Book.class, sql, begin, pageSize);
        return books;
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number num = (Number) queryForSingleValue(sql, min, max);
        return num.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where price between ? and ? order by price limit ?,?";
        List<Book> books = queryForList(Book.class, sql, min,max,begin, pageSize);
        return books;
    }
}
