package com.project.LinkC.service;

import com.project.LinkC.model.AbstractBaseEntity;

import java.util.List;


public interface BaseService<E extends AbstractBaseEntity> {

     E add(E e);

     void delete(int id);

     E getById(int id);

     E edit(E e);

     List<E> getAll();

}
