package com.su.booksale.mapper;

import com.su.booksale.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Mapper
@Repository
public interface BookMapper {
    List<Book> listBooks();

    Book getBookById(long id);

    void setBookPrice(@Param("bookId")long id, @Param("outPrice")BigDecimal price);

    void sellBook(@Param("bookId")long id,@Param("toSellNum")long toSellNum);

    int sellBook1(@Param("bookId")long id,@Param("toSellNum")long toSellNum);

    void returnBook(@Param("bookId")long id,@Param("returnNum")long returnNum);

    void stockBook(@Param("bookId")long id,@Param("stockNum") long stockNum,@Param("outPrice")BigDecimal outPrice);

    void addBook(Book book);

    long getMonthlyOutNum();

    BigDecimal getMonthlySales();

    List<Book>getRankingList();

    List<Book>search(@Param("keyWord") String keyWord);
}

