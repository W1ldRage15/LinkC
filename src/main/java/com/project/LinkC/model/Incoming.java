package com.project.LinkC.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "incoming")
public class Incoming extends AbstractBaseEntity {

    @OneToOne
    @JoinColumn(name = "productId",referencedColumnName = "id")
    private Product productId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    private int quantity;

    public Incoming() {
    }


    public Incoming(Integer id, Product productId, Date date) {
        super(id);
        this.productId = productId;
        this.date = date;
        this.quantity =  productId.getQuantity();
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product product) {
        this.productId = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return productId.getQuantity();
    }

    public void setQuantity() {
        this.quantity =  productId.getQuantity();
    }
}
