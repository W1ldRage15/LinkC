package com.project.LinkC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Producer;
import com.project.LinkC.repository.ProducerRepository;

import java.util.List;

@Service
@Transactional
public class ProducerService extends AbstractService<Producer, ProducerRepository> {
    public ProducerService(ProducerRepository repository) {
        super(repository);
    }
    @Transactional
    public List<Producer> getBySort1() {
        return repository.getBySort1();
    }
}
