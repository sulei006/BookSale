package com.su.booksale.controller;

import com.su.booksale.pojo.Book;
import com.su.booksale.pojo.StockRecord;
import com.su.booksale.service.BookService;
import com.su.booksale.service.StockRecordService;
import com.su.booksale.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @Autowired
    BookService bookService;
    @Autowired
    StockRecordService stockRecordService;

    @GetMapping("/suppliers/{id}")
    public String getSupplier(@PathVariable int id, Model model)
    {
        model.addAttribute("supperlier",supplierService.getSupplierById(id));
        return "purchase";
    }

    @PostMapping("/supplier/stock")
    public String purchase(StockRecord stockRecord, BigDecimal outPrice)
    {
        stockRecord.setTradeTime(new Date());
        bookService.stockBook(stockRecord.getBookId(),stockRecord.getInNumber(),stockRecord,outPrice);
        return "redirect:/suppliers";
    }
}
