package com.su.booksale.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su.booksale.mapper.BookMapper;
import com.su.booksale.mapper.ReturnRecordMapper;
import com.su.booksale.pojo.Book;
import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.pojo.StockRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import com.su.booksale.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    ReturnRecordService returnRecordService;

    @Autowired
    DaySellRecordService daySellRecordService;

    @Autowired
    StockRecordService stockRecordService;

    @Override
    public List<Book> listBooks() {
        return bookMapper.listBooks();
}

    @Override
    public Book getBookById(long id) {
      return bookMapper.getBookById(id);
    }

    @Transactional
    @Override
    public void setBookPrice(long id, BigDecimal price) {
        bookMapper.setBookPrice(id,price);
    }

    @Transactional
    @Override
    public DaySellRecord sellBook(long id, Long toSellNum) {
        int affectRow=bookMapper.sellBook1(id,toSellNum);
       // System.out.println(affectRow);
        if(affectRow==0)return null;
        Book book=bookMapper.getBookById(id);
        BigDecimal s=new BigDecimal(toSellNum);
        DaySellRecord daySellRecord=new DaySellRecord(book.getBookId(),book.getBookName(),book.getOutPrice(),toSellNum,book.getOutPrice().multiply(s),new Date());
        daySellRecordService.addDaySellRecord(daySellRecord);
        return daySellRecord;
    }

    @Transactional
    @Override
    public ReturnRecord returnBook(long id, Long returnNum) {
        bookMapper.returnBook(id,returnNum);
        Book book=bookMapper.getBookById(id);
        ReturnRecord returnRecord=new ReturnRecord(book.getBookId(),book.getBookName(),returnNum,new Date());
        returnRecordService.addReturnRecord(returnRecord);
        return returnRecord;
    }

    @Transactional
    @Override
    public  void stockBook(long id, Long stockNum,StockRecord stockRecord,BigDecimal outPrice) {
        Book book=bookMapper.getBookById(id);
        if(outPrice.equals(0))
        {
            outPrice=stockRecord.getInPrice();
        }
        if(book!=null) {
            bookMapper.stockBook(id, stockNum,outPrice);
            stockRecordService.addStockRecord(stockRecord);
        }
        else
        {
            Book book1=new Book(stockRecord.getBookId(),stockRecord.getBookName(),stockRecord.getInPrice(),outPrice,stockRecord.getInNumber(),new Long(0));
            bookMapper.addBook(book1);
            stockRecordService.addStockRecord(stockRecord);
        }
        }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public PageResult findPage1(PageRequest pageRequest,String keyWord) {
        return PageUtils.getPageResult(pageRequest, getPageInfo1(pageRequest,keyWord));
    }

    @Override
    public long getMonthlyOutNum() {
        return bookMapper.getMonthlyOutNum();
    }

    @Override
    public BigDecimal getMonthlySales() {
        return bookMapper.getMonthlySales();
    }

    @Override
    public List<Book> getRankingList() {
        return bookMapper.getRankingList();
    }



    private PageInfo<Book> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookMapper.listBooks();
        return new PageInfo<Book>(books);
    }

    private PageInfo<Book> getPageInfo1(PageRequest pageRequest,String keyWord) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookMapper.search(keyWord);
        return new PageInfo<Book>(books);
    }
}