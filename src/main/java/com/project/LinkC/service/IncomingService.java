package com.project.LinkC.service;

import com.project.LinkC.model.Incoming;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.repository.IncomingRepository;

import java.util.List;

@Service
@Transactional
public class IncomingService extends AbstractService<Incoming, IncomingRepository> {

    public IncomingService(IncomingRepository repository) {
        super(repository);
    }
    public List<Incoming> getBySort5() {
        return repository.getBySort5();
    }
}
