package com.project.LinkC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "producer")
public class Producer extends AbstractBaseEntity {
    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String address;

    public Producer() {
    }

    public Producer(Integer id, String name, String phone, String address) {
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
