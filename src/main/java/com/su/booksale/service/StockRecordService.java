package com.su.booksale.service;

import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.pojo.StockRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;

import java.util.List;


public interface StockRecordService {
    List<StockRecord> listStockRecords();
    void addStockRecord(StockRecord stockRecord);
    public PageResult findPage(PageRequest pageRequest) ;
}
