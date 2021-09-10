package com.su.booksale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaySellRecord {
    private Long bookId;
    private String bookName;
    private BigDecimal outPrice;
    private Long outNumber;
    private BigDecimal income;
    private Date tradeDate;
}
