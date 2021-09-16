package com.zzf.service;

import com.zzf.pojo.Book;
import com.zzf.pojo.Page;

import java.util.List;

/**
 * @author zzf
 * @create 2021-08-21 13:49
 */
public interface BookService {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
