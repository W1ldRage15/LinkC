package com.project.LinkC.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transport")
public class Transport extends AbstractBaseEntity {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @Column
    private double total;

    @Column
    private double totalNDS;


    public Transport() {
    }

    public Transport(Integer id, Date date, double total, double totalNDS) {
        super(id);
        this.date = date;
        this.total = total;
        this.totalNDS = Math.round(total*1.2);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalNDS() {
        return Math.round(Math.round(total*1.2));
    }

    public void setTotalNDS() {
        this.totalNDS = Math.round(total*1.2);
    }
}




