package com.project.LinkC.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "earnings")
public class Earnings extends AbstractBaseEntity {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product productId;


    @Column
    private int quantity;


    public Earnings() {
    }

    public Earnings(Integer id, Date date, Product productId, int quantity) {
        super(id);
        this.date = date;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}




