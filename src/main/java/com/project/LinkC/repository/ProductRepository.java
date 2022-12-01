package com.project.LinkC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Product;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends BaseRepository<Product> {
    @Query("from Product where quantity = (select min (quantity) from Product )")
    Product getProductByMinQuantity();

    @Query("from Product where quantity = (select max (quantity) from Product )")
    Product getProductByMaxQuantity();

    @Query("select sum (quantity) from  Product ")
    int getQuanBySum();

    @Query("from Product order by price")
    List<Product> getBySort();

}
