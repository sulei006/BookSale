package com.su.booksale.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRecord {
    private Long bookId;
    private String bookName;
    private Long returnNum;
    private Date returnTime;
}
