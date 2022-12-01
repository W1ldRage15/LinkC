package com.project.LinkC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consumer")
public class Consumer extends AbstractBaseEntity {
    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String address;

    public Consumer() {
    }

    public Consumer(Integer id, String phone, String name,String address) {
        super(id);
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
