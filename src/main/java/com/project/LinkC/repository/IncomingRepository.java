package com.project.LinkC.repository;

import com.project.LinkC.model.Incoming;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface IncomingRepository extends BaseRepository<Incoming> {
    @Query("from Incoming order by date")
    List<Incoming> getBySort5();
}
