package com.ksv.WorkingWithDB.sn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="serial_number")
public class SnModel {
    @Id
    private Integer id;
    private Integer sn;
    @Column(name = "name_c")
    private String name;

    public SnModel() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }
}
