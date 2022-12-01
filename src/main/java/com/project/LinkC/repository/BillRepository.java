package com.project.LinkC.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Bill;

import java.util.List;

@Repository
@Transactional
public interface BillRepository extends BaseRepository<Bill> {
    @Query("select sum (productId.price*quantity) from Bill ")
    double getBillSumTotal();

    @Query("from Bill order by date")
    List<Bill> getBySort3();
}

