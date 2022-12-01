package com.project.LinkC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Stock;

import java.util.List;

@Repository
@Transactional
public interface StockRepository extends BaseRepository<Stock> {
    @Query("from Stock order by date")
    List<Stock> getBySort6();
}
