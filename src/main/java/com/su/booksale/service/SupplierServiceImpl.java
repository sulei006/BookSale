package com.su.booksale.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su.booksale.mapper.SupplierMapper;
import com.su.booksale.pojo.Book;
import com.su.booksale.pojo.Supplier;
import com.su.booksale.util.PageRequest;
import com.su.booksale.util.PageResult;
import com.su.booksale.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<Supplier> listSuppliers() {
      return supplierMapper.listSuppliers();
    }

    @Override
    public Supplier getSupplierById(long id) {
        return supplierMapper.getSupplierById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public PageResult findPage1(PageRequest pageRequest, String keyWord) {
        return PageUtils.getPageResult(pageRequest, getPageInfo1(pageRequest,keyWord));
    }

    private PageInfo<Supplier> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Supplier> suppliers = supplierMapper.listSuppliers();
        return new PageInfo<Supplier>(suppliers);
    }

    private PageInfo<Supplier> getPageInfo1(PageRequest pageRequest,String keyWord) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Supplier> suppliers = supplierMapper.search(keyWord);
        return new PageInfo<Supplier>(suppliers);
    }

}
