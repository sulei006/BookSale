package com.su.booksale.service;

import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;

import java.util.List;

public interface DaySellRecordService {
    List<DaySellRecord> listDaySellRecords();
    void addDaySellRecord(DaySellRecord daySellRecord);
    public PageResult findPage(PageRequest pageRequest) ;
}
