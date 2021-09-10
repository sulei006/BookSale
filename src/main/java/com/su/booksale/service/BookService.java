package com.su.booksale.service;

import com.su.booksale.pojo.Book;
import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.pojo.StockRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Book getBookById(long id);
    void setBookPrice(long id, BigDecimal price);
    DaySellRecord sellBook(long id, Long toSellNum);
    ReturnRecord returnBook(long id, Long returnNum);
    public void stockBook(long id, Long stockNum,StockRecord stockRecord,BigDecimal outPrice);

    PageResult findPage(PageRequest pageRequest);
    PageResult findPage1(PageRequest pageRequest,String keyWord);

    long getMonthlyOutNum();

    BigDecimal getMonthlySales();

    List<Book>getRankingList();

}
