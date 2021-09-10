package com.su.booksale.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su.booksale.mapper.StockRecordMapper;
import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.pojo.StockRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import com.su.booksale.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockRecordServiceImpl implements  StockRecordService{

    @Autowired
    StockRecordMapper stockRecordMapper;

    @Override
    public List<StockRecord> listStockRecords() {
        return stockRecordMapper.listStockRecords();
    }

    @Override
    public void addStockRecord(StockRecord stockRecord) {
        stockRecordMapper.addStockRecord(stockRecord);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<StockRecord> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<StockRecord> stockRecords = stockRecordMapper.listStockRecords();
        return new PageInfo<StockRecord>(stockRecords);
    }
}
