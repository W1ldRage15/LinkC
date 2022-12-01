package com.project.LinkC.service;

import com.project.LinkC.model.Transport;
import com.project.LinkC.repository.TransportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransportService extends AbstractService<Transport, TransportRepository> {

    public TransportService(TransportRepository repository) {
        super(repository);
    }
    public List<Transport> getBySort7() {
        return repository.getBySort7();
    }
}
