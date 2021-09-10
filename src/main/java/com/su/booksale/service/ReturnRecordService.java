package com.su.booksale.service;

import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;

import java.util.List;

public interface ReturnRecordService {
    List<ReturnRecord> listReturnRecords();
    void addReturnRecord(ReturnRecord returnRecord);
    public PageResult findPage(PageRequest pageRequest) ;
}
