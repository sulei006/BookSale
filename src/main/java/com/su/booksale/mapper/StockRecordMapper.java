package com.su.booksale.mapper;


import com.su.booksale.pojo.StockRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockRecordMapper {
    List<StockRecord> listStockRecords();
    void addStockRecord(StockRecord stockRecord);
}
