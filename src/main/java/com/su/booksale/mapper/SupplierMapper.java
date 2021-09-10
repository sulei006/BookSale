package com.su.booksale.mapper;

import com.su.booksale.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierMapper {
    List<Supplier> listSuppliers();
    Supplier getSupplierById(long id);
    List<Supplier> search(@Param("keyWord")String keyWord);
}
