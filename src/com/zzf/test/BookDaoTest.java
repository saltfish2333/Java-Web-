package com.zzf.test;

import com.zzf.dao.BookDao;
import com.zzf.dao.impl.BookDaoImpl;
import com.zzf.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-21 13:29
 */
public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void updateBookTest() {
        bookDao.updateBook(new Book(21,"红楼梦","曹雪芹",new BigDecimal(99.99),999999,0,null));
    }

    @Test
    public void deleteBookByIdTest() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void addBookTest() {
        bookDao.addBook(new Book(1,"石头记","高鹗",new BigDecimal(99.99),999999,0,null));
    }

    @Test
    public void queryBookByIdTest() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooksTest() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }
}