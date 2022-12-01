package com.project.LinkC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.Product;
import com.project.LinkC.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductService extends AbstractService<Product, ProductRepository> {

    public ProductService(ProductRepository repository) {
        super(repository);
    }
    @Transactional
    public Product getProductByMaxQuantity() {
        return repository.getProductByMaxQuantity();
    }


    @Transactional
    public Product getProductByMinQuantity() {
        return repository.getProductByMinQuantity();
    }
    @Transactional
    public int getQuanBySum() {
        return repository.getQuanBySum();
    }
    @Transactional
    public List<Product> getBySort() {
        return repository.getBySort();
    }
}
