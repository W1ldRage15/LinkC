package com.project.LinkC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Consumer;
import com.project.LinkC.repository.ConsumerRepository;

import java.util.List;


@Service
@Transactional
public class ConsumerService extends AbstractService<Consumer, ConsumerRepository> {

    public ConsumerService(ConsumerRepository repository) {
        super(repository);
    }
    @Transactional
    public List<Consumer> gerBySort2(){
        return repository.getBySort2();
    }
}
