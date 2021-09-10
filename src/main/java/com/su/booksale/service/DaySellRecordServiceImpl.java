package com.su.booksale.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su.booksale.mapper.DaySellRecordMapper;
import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.pojo.Supplier;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import com.su.booksale.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaySellRecordServiceImpl implements DaySellRecordService{
    @Autowired
    DaySellRecordMapper daySellRecordMapper;

    @Override
    public List<DaySellRecord> listDaySellRecords() {
        return daySellRecordMapper.listDaySellRecords();
    }

    @Override
    public void addDaySellRecord(DaySellRecord daySellRecord) {
        daySellRecordMapper.addDaySellRecord(daySellRecord);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<DaySellRecord> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<DaySellRecord> daySellRecords = daySellRecordMapper.listDaySellRecords();
        return new PageInfo<DaySellRecord>(daySellRecords);
    }
}
