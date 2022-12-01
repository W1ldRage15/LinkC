package com.project.LinkC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Stock;
import com.project.LinkC.repository.StockRepository;

import java.util.List;


@Service
@Transactional
public class StockService extends AbstractService<Stock, StockRepository> {
    public StockService(StockRepository repository) {
        super(repository);
    }
    public List<Stock> getBySort6() {
        return repository.getBySort6();
    }
}
