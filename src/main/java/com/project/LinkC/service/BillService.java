package com.project.LinkC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Bill;
import com.project.LinkC.repository.BillRepository;

import java.util.List;

@Service
@Transactional
public class BillService extends AbstractService<Bill, BillRepository> {
    public BillService(BillRepository repository) {
        super(repository);
    }
    @Transactional
    public double getBySumTotal() {
        return repository.getBillSumTotal();
    }

    @Transactional
    public List<Bill> getBySort3() {
        return repository.getBySort3();
    }
}
