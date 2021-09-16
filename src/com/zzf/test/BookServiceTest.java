package com.zzf.test;

import com.zzf.pojo.Book;
import com.zzf.service.BookService;
import com.zzf.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author zzf
 * @create 2021-08-21 13:54
 */
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"风月宝鉴","假宝玉",new BigDecimal(10.0),545,123,null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(1,"风月宝鉴","假宝玉",new BigDecimal(10.0),545,123,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }
}