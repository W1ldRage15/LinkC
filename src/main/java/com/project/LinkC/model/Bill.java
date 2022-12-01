package com.project.LinkC.model;

import org.decimal4j.util.DoubleRounder;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill extends AbstractBaseEntity  {
    @OneToOne
    @JoinColumn(name = "productId",referencedColumnName = "id")
    private Product productId;

    @OneToOne
    @JoinColumn(name = "consumerId",referencedColumnName = "id")
    private Consumer consumerId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @Column
    private int quantity;

    @Column
    private double total;

    @Column
    private double totalNDS;

    public Bill() {
    }

    public Bill(Integer id, Product productId, Consumer consumerId, Date date, int quantity) {
        super(id);
        this.productId = productId;
        this.consumerId = consumerId;
        this.date = date;
        this.quantity = quantity;
        this.total = productId.getPrice()*quantity;
        this.totalNDS = Math.round(productId.getPrice()*quantity*1.2);
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Consumer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Consumer consumerId) {
        this.consumerId = consumerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return DoubleRounder.round(productId.getPrice()*quantity,2);
    }

    public void setTotal() {
        this.total = productId.getPrice()*quantity;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public double getTotalNDS() {
        return Math.round(productId.getPrice()*quantity*1.2);
    }

    public void setTotalNDS() {
        this.totalNDS = Math.round(productId.getPrice()*quantity*1.2);;
    }
}
