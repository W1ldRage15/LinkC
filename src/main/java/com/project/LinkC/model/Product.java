package com.project.LinkC.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends AbstractBaseEntity {

    @OneToOne
    @JoinColumn(name = "producerId",referencedColumnName = "id")
    private Producer producerId;
    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private double price;

    @Column
    private double priceNDS;

    public Product() {
    }

    public Product(Integer id, Producer producerId, String name, Integer quantity, double price) {
        super(id);
        this.producerId = producerId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.priceNDS = Math.round(price*1.2);
    }

    public Producer getProducerId() {
        return producerId;
    }

    public void setProducerId(Producer producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceNDS() {
        return Math.round(price*1.2);
    }

    public void setPriceNDS() {
        this.priceNDS = Math.round(price*1.2);
    }
}
