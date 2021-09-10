package com.su.booksale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.su.booksale.mapper")
public class BooksaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksaleApplication.class, args);
    }

}
