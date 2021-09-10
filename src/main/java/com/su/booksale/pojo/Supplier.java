package com.su.booksale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private Long id;
    private Long bookId;
    private String bookName;
    private String supplierName;
    private BigDecimal price;
}
