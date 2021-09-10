package com.su.booksale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    public long monthlySales;
    public BigDecimal totalIncome;
    public List<Book> rankingList;
}
