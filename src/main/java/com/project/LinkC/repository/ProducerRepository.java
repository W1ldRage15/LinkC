package com.project.LinkC.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Producer;

import java.util.List;

@Repository
@Transactional
public interface ProducerRepository extends BaseRepository<Producer> {
    @Query("from Producer order by name")
    List<Producer> getBySort1();
}
