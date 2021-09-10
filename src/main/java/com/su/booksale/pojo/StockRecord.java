package com.su.booksale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRecord {
    private Long bookId;
    private String bookName;
    private String supplierName;
    private BigDecimal inPrice;
    private Long inNumber;
    private BigDecimal totalCost;
    private Date tradeTime;
}
