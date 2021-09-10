package com.su.booksale.service;

import com.su.booksale.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    @Autowired
    BookMapper bookMapper;


    public void test()
    {
        if(bookMapper.listBooks()==null)
        System.out.println( "null");
    }
}