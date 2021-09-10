package com.su.booksale.mapper;

import com.su.booksale.pojo.DaySellRecord;
import com.su.booksale.pojo.ReturnRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReturnRecordMapper {
    List<ReturnRecord> listReturnRecords();

    void addReturnRecord(ReturnRecord returnRecord);
}
