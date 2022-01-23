package com.ksv.WorkingWithDB.sn;

import javax.persistence.*;

@Entity
@Table (name="serial_number_old")
public class SnModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer sn;
    @Column(name = "name_c")
    private String name;

    public SnModel() {
    }

    public SnModel(Integer sn, String name){
        this.sn = sn;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getSn() {
        return sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
