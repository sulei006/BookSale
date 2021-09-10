package com.su.booksale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long bookId;
    private String bookName;
    private BigDecimal inPrice;
    private BigDecimal outPrice;
    private Long leftNum;
    private Long soldNum;


}
