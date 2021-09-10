package com.su.booksale.service;

import com.su.booksale.pojo.Supplier;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import com.su.booksale.util.PageUtils;

import java.util.List;

public interface SupplierService {
    List<Supplier> listSuppliers();
    Supplier getSupplierById(long id);

    public PageResult findPage(PageRequest pageRequest);
    public PageResult findPage1(PageRequest pageRequest,String keyWord);
}
