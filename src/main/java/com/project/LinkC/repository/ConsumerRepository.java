package com.project.LinkC.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Consumer;

import java.util.List;

@Repository
@Transactional
public interface ConsumerRepository extends BaseRepository<Consumer> {
    @Query("from Consumer order by name")
    List<Consumer> getBySort2();
}
