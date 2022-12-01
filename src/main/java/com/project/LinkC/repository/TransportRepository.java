package com.project.LinkC.repository;

import com.project.LinkC.model.Transport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface TransportRepository extends BaseRepository<Transport> {
    @Query("from Transport order by date")
    List<Transport> getBySort7();
}
