package com.su.booksale.mapper;


import com.su.booksale.pojo.DaySellRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DaySellRecordMapper {

    public List<DaySellRecord> listDaySellRecords();
    public void addDaySellRecord(DaySellRecord daySellRecord);
}
