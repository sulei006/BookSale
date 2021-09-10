package com.su.booksale.controller;

import com.su.booksale.pojo.Book;
import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.service.BookService;
import com.su.booksale.service.DaySellRecordService;
import com.su.booksale.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    ReturnRecordService returnRecordService;
    @Autowired
    DaySellRecordService daySellRecordService;

    @GetMapping("/book/{id}")
    public String editBookInfo(@PathVariable long id, Model model)
    {
        model.addAttribute("book",bookService.getBookById(id));
        return "book";
    }

    @PostMapping("/chaInpri/{id}")
    public String changeInprice(@PathVariable int id,BigDecimal outPrice, RedirectAttributes model)
    {
        bookService.setBookPrice(id,outPrice);
        String bookName=bookService.getBookById(id).getBookName();
        bookName="<<"+bookName+">>";
        model.addFlashAttribute("message",bookName+"修改售价成功。");
        return "redirect:/";
    }


    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable int id, Long returnNum, RedirectAttributes model)
    {
        String strDateFormat = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        ReturnRecord returnRecord=bookService.returnBook(id,returnNum);
        String msg="书名：<<"+returnRecord.getBookName()+">>\n";
        msg+="退货数量："+returnNum+"\n";
        msg+="退货时间："+sdf.format(returnRecord.getReturnTime())+"\n\n";
        msg+="操作成功";
        model.addFlashAttribute("message",msg);
        return "redirect:/";
    }

    @PostMapping("/sale/{id}")
    public String sale(@PathVariable int id,Long toSellNum, RedirectAttributes model)
    {
        DaySellRecord daySellRecord=bookService.sellBook(id,toSellNum);
        if (daySellRecord==null)
            return "redirect:/";

        String strDateFormat = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        String bookName=daySellRecord.getBookName();
        bookName="<<"+bookName+">>";
        String msg="书名："+bookName+"\n";
        msg+="售出数量："+toSellNum+"\n";
        msg+="售价："+daySellRecord.getOutPrice()+"\n";
        msg+="销售额："+daySellRecord.getIncome()+"\n";
        msg+="交易时间："+sdf.format(daySellRecord.getTradeDate())+"\n\n";
        msg+="操作成功";
        model.addFlashAttribute("message",msg);
        return "redirect:/";
    }
}
