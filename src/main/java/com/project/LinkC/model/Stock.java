package com.project.LinkC.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock extends AbstractBaseEntity {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column
    private Date date;

    @Column
    private int quantity;


    public Stock() {
    }

    public Stock(Integer id, Date date, int quantity) {
        super(id);
        this.date = date;
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
