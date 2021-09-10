package com.su.booksale.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su.booksale.mapper.ReturnRecordMapper;
import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.pojo.ReturnRecord;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import com.su.booksale.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReturnRecordServiceImpl implements ReturnRecordService {
    @Autowired
    ReturnRecordMapper returnRecordMapper;
    @Override
    public List<ReturnRecord> listReturnRecords() {

        return returnRecordMapper.listReturnRecords();
    }

    @Override
    public void addReturnRecord(ReturnRecord returnRecord)
    {
        returnRecordMapper.addReturnRecord(returnRecord);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<ReturnRecord> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ReturnRecord> returnRecords = returnRecordMapper.listReturnRecords();
        return new PageInfo<ReturnRecord>(returnRecords);
    }
}
