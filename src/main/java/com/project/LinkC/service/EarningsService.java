package com.project.LinkC.service;

import com.project.LinkC.model.Earnings;
import com.project.LinkC.repository.EarningsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EarningsService extends AbstractService<Earnings, EarningsRepository> {

    public EarningsService(EarningsRepository repository) {
        super(repository);
    }
    public List<Earnings> getBySort4() {
        return repository.getBySort4();
    }
}
