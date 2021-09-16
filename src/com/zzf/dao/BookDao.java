package com.zzf.dao;

import com.zzf.pojo.Book;

import java.util.List;

/**
 * @author zzf
 * @create 2021-08-21 13:01
 */
public abstract interface BookDao {
    public int updateBook(Book book);
    public int deleteBookById(Integer id);
    public int addBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max);
}
