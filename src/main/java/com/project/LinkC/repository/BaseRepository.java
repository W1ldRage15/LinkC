package com.project.LinkC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.AbstractBaseEntity;


@NoRepositoryBean
@Transactional

public interface BaseRepository<E extends AbstractBaseEntity> extends CrudRepository<E,Integer> {

    E getById(Integer integer);
}
