package com.su.booksale.controller;


import com.su.booksale.pojo.Statistics;
import com.su.booksale.service.*;
import com.su.booksale.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class IndexController {

    @Autowired
    BookService bookService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    ReturnRecordService returnRecordService;

    @Autowired
    DaySellRecordService daySellRecordService;

    @Autowired
    StockRecordService stockRecordService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                        @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize, Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);

        model.addAttribute("page",bookService.findPage(pageRequest));
        return "index";
    }



    @GetMapping("/suppliers")
    public String suppliers(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        model.addAttribute("page",supplierService.findPage(pageRequest));
        return "suppliers";
    }

    @GetMapping("/returnRecs")
    public String returnRecords(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        model.addAttribute("page",returnRecordService.findPage(pageRequest));
        return "returnRecords";
    }

    @GetMapping("/daySell")
    public String daySell(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                          @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        model.addAttribute("page",daySellRecordService.findPage(pageRequest));
        return "daySell";
    }

    @GetMapping("/stockRecs")
    public String stockRecords(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        model.addAttribute("page",stockRecordService.findPage(pageRequest));
        return "stockRecords";
    }

    @GetMapping("/statistics")
    public String statistics(Model model)
    {
        Statistics statistics=new Statistics();
        statistics.setMonthlySales(bookService.getMonthlyOutNum());
        statistics.setTotalIncome(bookService.getMonthlySales());
        statistics.setRankingList(bookService.getRankingList());
        model.addAttribute("statistics",statistics);
        return "statistics";
    }

    @PostMapping("/search/{flag}")
    public String search(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,@PathVariable int flag, String keyWord,Model model)
    {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        if(flag==1) {
            model.addAttribute("page", bookService.findPage1(pageRequest, keyWord));
            model.addAttribute("keyWord", keyWord);
            return "bookSearch";
        }
        else {
            model.addAttribute("page", supplierService.findPage1(pageRequest, keyWord));
            model.addAttribute("keyWord", keyWord);
            return "supplierSearch";
        }
    }

    @GetMapping("/search/1")
    public String bookSearchToNext(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize, String keyWord,Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        model.addAttribute("page",bookService.findPage1(pageRequest,keyWord));
        model.addAttribute("keyWord",keyWord);
        return "bookSearch";
    }

    @GetMapping("/search/4")
    public String supplierSearchToNext(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize, String keyWord,Model model)
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageSize(pageSize);
        pageRequest.setPageNum(pageNum);
        model.addAttribute("page",supplierService.findPage1(pageRequest,keyWord));
        model.addAttribute("keyWord",keyWord);
        return "supplierSearch";
    }
}
