package com.project.LinkC.repository;

import com.project.LinkC.model.Earnings;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface EarningsRepository extends BaseRepository<Earnings> {
    @Query("from Earnings order by date")
    List<Earnings> getBySort4();
}
